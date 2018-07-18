package org.bc.common.interceptor;

import org.bc.common.vo.Page;
import org.bc.common.vo.ReflectUtil;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.Properties;

/**
 * @author Administrator
 * @date 2017/10/10
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class }),
		@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = { Statement.class }) })
public class PageInterceptor implements Interceptor {
	private static Logger logger = LogManager.getLogger(PageInterceptor.class);
	public static final ThreadLocal<Page> LOCAL_PAGE = new ThreadLocal<Page>();

	/**
	 * 开始分页
	 * @param pageNum
	 * @param pageSize
	 */
	public static void startPage(int pageNum, int pageSize) {

	    LOCAL_PAGE.set(new Page(pageNum, pageSize));
	}

	public static void startPage(Page page) {
		if (page != null) {
			LOCAL_PAGE.set(page);
		}
	}

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		if (LOCAL_PAGE.get() == null) {
			return invocation.proceed();
		}
		if (invocation.getTarget() instanceof StatementHandler) {
			StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
			MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
			// 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环
			// 可以分离出最原始的的目标类)
			while (metaStatementHandler.hasGetter("h")) {
				Object object = metaStatementHandler.getValue("h");
				metaStatementHandler = SystemMetaObject.forObject(object);
			}
			// 分离最后一个代理对象的目标类
			while (metaStatementHandler.hasGetter("target")) {
				Object object = metaStatementHandler.getValue("target");
				metaStatementHandler = SystemMetaObject.forObject(object);
			}
			MappedStatement mappedStatement = (MappedStatement) metaStatementHandler
					.getValue("delegate.mappedStatement");
			// 分页信息if (localPage.get() != null) {
			Page page = LOCAL_PAGE.get();
			BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
			// 分页参数作为参数对象parameterObject的一个属性
			String sql = boundSql.getSql();
			// 重写sql
			String pageSql = buildPageSql(sql, page);
			// 重写分页sql
			metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
			Connection connection = (Connection) invocation.getArgs()[0];
			// 重设分页参数里的总页数等
			setPageParameter(sql, connection, mappedStatement, boundSql, page);
			// 将执行权交给下一个拦截器
			return invocation.proceed();
		} else if (invocation.getTarget() instanceof ResultSetHandler) {
			Object result = invocation.proceed();
			LOCAL_PAGE.remove();
			return result;
		}
		return null;
	}

	/**
	 * 只拦截这两种类型的 <br>
	 * StatementHandler <br>
	 * ResultSetHandler
	 * @param target
	 * @return
	 */
	@Override
	public Object plugin(Object target) {
		if (target instanceof StatementHandler || target instanceof ResultSetHandler) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}

	@Override
	public void setProperties(Properties properties) {
	}

	/**
	 * 修改原SQL为分页SQL
	 * @param sql
	 * @param page
	 * @return
	 */
	private String buildPageSql(String sql, Page page) {
		if (page.getPageNo() == 0 && page.getPageSize() == -1) {// 此时不分页
			return sql;
		}
		StringBuilder pageSql = new StringBuilder(200);
		int offset = page.getStartPoint();
		pageSql.append(sql).append(" limit ").append(offset).append(",").append(page.getPageSize());
		return pageSql.toString();
	}

	/**
	 * 获取总记录数
	 * @param sql
	 * @param connection
	 * @param mappedStatement
	 * @param boundSql
	 * @param page
	 */
	private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement, BoundSql boundSql,
			Page page) {
		// 记录总记录数
		if (page.getPageNo() == 0 && page.getPageSize() == -1) {// 此时不分页
			return;
		}
		String countSql = "select count(0) as totalPages from (" + sql + ") as count_sql";
		PreparedStatement countStmt = null;
		ResultSet rs = null;
		try {
			countStmt = connection.prepareStatement(countSql);
			BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,
					boundSql.getParameterMappings(), boundSql.getParameterObject());
			Field metaParamsField = ReflectUtil.getFieldByFieldName(boundSql, "metaParameters");
			if (metaParamsField != null) {
                MetaObject mo = null;
                mo = (MetaObject) ReflectUtil.getValueByFieldName(boundSql, "metaParameters");
                ReflectUtil.setValueByFieldName(countBS, "metaParameters", mo);
			}
			setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());
			rs = countStmt.executeQuery();
			int totalCount = 0;
			if (rs.next()) {
				totalCount = rs.getInt(1);
			}
			page.setTotalRecords(totalCount);
			int totalPage = totalCount / page.getPageSize() + ((totalCount % page.getPageSize() == 0) ? 0 : 1);
			page.setTotalPages(totalPage);
        } catch (SQLException e) {
            logger.error("Ignore this SQLException", e);
        } catch (SecurityException e) {
            logger.error("Ignore this SecurityException", e);
        } catch (NoSuchFieldException e) {
            logger.error("Ignore this NoSuchFieldException", e);
        } catch (IllegalArgumentException e) {
            logger.error("Ignore this IllegalArgumentException", e);
        } catch (IllegalAccessException e) {
            logger.error("Ignore this IllegalAccessException", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				logger.error("Ignore this exception", e);
			}
			try {
				if (countStmt != null) {
					countStmt.close();
				}
			} catch (SQLException e) {
				logger.error("Ignore this exception", e);
			}
		}
	}

	/**
	 * 代入参数值
	 * @param ps
	 * @param mappedStatement
	 * @param boundSql
	 * @param parameterObject
	 * @throws SQLException
	 */
	private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,
			Object parameterObject) throws SQLException {
		ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
		parameterHandler.setParameters(ps);
	}
}
