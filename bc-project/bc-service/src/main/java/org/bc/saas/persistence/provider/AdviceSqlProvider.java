package org.bc.saas.persistence.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.bc.saas.common.utils.StringUtils;
import org.bc.saas.persistence.entity.Advice;
import org.bc.saas.vo.AdviceParam;

 

public class AdviceSqlProvider {
	public String insertSelective(Advice record) {
		SQL sql = new SQL();
		sql.INSERT_INTO("c_advice");
		if (record.getId() != null) {
			sql.VALUES("id", "#{id,jdbcType=BIGINT}");
		}
		if (record.getCode() != null) {
			sql.VALUES("code", "#{code,jdbcType=VARCHAR}");
		}
		if (record.getPy() != null) {
			sql.VALUES("py", "#{py,jdbcType=VARCHAR}");
		}
		if (record.getName() != null) {
			sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
		}
		if (record.getIdx() != null) {
			sql.VALUES("idx", "#{idx,jdbcType=INTEGER}");
		}
		if (record.getDescription() != null) {
			sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
		}
		if (record.getDeptTypeId() != null) {
			sql.VALUES("dept_type_id", "#{deptTypeId,jdbcType=INTEGER}");
		}
		if (record.getOperateDesc() != null) {
			sql.VALUES("operate_desc", "#{operateDesc,jdbcType=VARCHAR}");
		}
		if (record.getProvenance() != null) {
			sql.VALUES("provenance", "#{provenance,jdbcType=VARCHAR}");
		}
		if (record.getLimitType() != null) {
			sql.VALUES("limit_type", "#{limitType,jdbcType=INTEGER}");
		}
		if (record.getExplainDesc() != null) {
			sql.VALUES("explain_desc", "#{explainDesc,jdbcType=VARCHAR}");
		}
		if (record.getIsInfomationExplain() != null) {
			sql.VALUES("is_infomation_explain", "#{isInfomationExplain,jdbcType=INTEGER}");
		}
		if (record.getIsHealthHazardSolution() != null) {
			sql.VALUES("is_health_hazard_solution", "#{isHealthHazardSolution,jdbcType=INTEGER}");
		}
		if (record.getHealthHazard() != null) {
			sql.VALUES("health_hazard", "#{healthHazard,jdbcType=VARCHAR}");
		}
		if (record.getSolution() != null) {
			sql.VALUES("solution", "#{solution,jdbcType=VARCHAR}");
		}
		if (record.getStatus() != null) {
			sql.VALUES("status", "#{status,jdbcType=BIT}");
		}
		if (record.getUpdatedBy() != null) {
			sql.VALUES("updated_by", "#{updatedBy,jdbcType=INTEGER}");
		}
		sql.VALUES("updated_on", "now()");
		if (record.getIpAddress() != null) {
			sql.VALUES("ip_address", "#{ipAddress,jdbcType=VARCHAR}");
		}
		return sql.toString();
	}

	public String updateByPrimaryKeySelective(Advice record) {
		SQL sql = new SQL();
		sql.UPDATE("c_advice");
		if (record.getCode() != null) {
			sql.SET("code = #{code,jdbcType=VARCHAR}");
		}
		if (record.getPy() != null) {
			sql.SET("py = #{py,jdbcType=VARCHAR}");
		}
		if (record.getName() != null) {
			sql.SET("name = #{name,jdbcType=VARCHAR}");
		}
		if (record.getIdx() != null) {
			sql.SET("idx = #{idx,jdbcType=INTEGER}");
		}
		if (record.getDescription() != null) {
			sql.SET("description = #{description,jdbcType=VARCHAR}");
		}
		if (record.getDeptTypeId() != null) {
			sql.SET("dept_type_id = #{deptTypeId,jdbcType=INTEGER}");
		}
		if (record.getOperateDesc() != null) {
			sql.SET("operate_desc = #{operateDesc,jdbcType=VARCHAR}");
		}
		if (record.getProvenance() != null) {
			sql.SET("provenance = #{provenance,jdbcType=VARCHAR}");
		}
		if (record.getLimitType() != null) {
			sql.SET("limit_type = #{limitType,jdbcType=INTEGER}");
		}
		if (record.getExplainDesc() != null) {
			sql.SET("explain_desc = #{explainDesc,jdbcType=VARCHAR}");
		}
		if (record.getIsInfomationExplain() != null) {
			sql.SET("is_infomation_explain = #{isInfomationExplain,jdbcType=INTEGER}");
		}
		if (record.getIsHealthHazardSolution() != null) {
			sql.SET("is_health_hazard_solution = #{isHealthHazardSolution,jdbcType=INTEGER}");
		}
		if (record.getHealthHazard() != null) {
			sql.SET("health_hazard = #{healthHazard,jdbcType=VARCHAR}");
		}
		if (record.getSolution() != null) {
			sql.SET("solution = #{solution,jdbcType=VARCHAR}");
		}
		if (record.getStatus() != null) {
			sql.SET("status = #{status,jdbcType=BIT}");
		}
		if (record.getUpdatedBy() != null) {
			sql.SET("updated_by = #{updatedBy,jdbcType=INTEGER}");
		}
		sql.SET("updated_on = now()");
		if (record.getIpAddress() != null) {
			sql.SET("ip_address = #{ipAddress,jdbcType=VARCHAR}");
		}
		sql.WHERE("id = #{id,jdbcType=BIGINT}");
		return sql.toString();
	}

	public String selectAdvicesHandler(@Param("queryParam") AdviceParam queryParam) {
		SQL sql = new SQL();
		sql.SELECT(" a.id,a.name,if(a.status=1,1,0) as status,a.dept_type_id,d.name as department_name ",
				" (case a.updated_by when 0 then 'admin' else (select u.name from r_user u where u.id = a.updated_by ) end) as updated_name "+
				" from c_advice a left join c_department d on a.dept_type_id = d.id");
		if (!StringUtils.isEmpty(queryParam.getName())) {
			sql.WHERE("a.name like concat('%',#{queryParam.name,jdbcType=VARCHAR},'%') ");
		}
		if (queryParam.getDeptTypeId() != null) {
			sql.WHERE("a.dept_type_id = #{queryParam.deptTypeId,jdbcType=INTEGER}");
		}
		return sql.toString();
	}

	public String selectView(@Param("departmentId") String departmentId) {
		return new SQL() {
			{
				SELECT(" c.id,c.code,c.name,c.description");
				FROM("c_advice c ");
				if (!StringUtils.isEmpty(departmentId)) {
					WHERE("c.dept_type_id= #{departmentId}");
				}
				WHERE("c.status=1");
			}
		}.toString();
	}
}
