package org.bc.saas.persistence;

import java.util.List;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.bc.saas.persistence.entity.Advice;
import org.bc.saas.persistence.provider.AdviceSqlProvider;
import org.bc.saas.vo.AdviceComboBoxView;
import org.bc.saas.vo.AdviceParam;
import org.bc.saas.vo.AdviceView;
import org.springframework.stereotype.Repository;

 



@Mapper
@Repository
public interface AdviceMapper {
	@Delete({ "delete from c_advice", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	@Insert({ "insert into c_advice (id, code, ", "py, name, idx, ", "description, dept_type_id, ",
			"operate_desc, provenance, ", "limit_type, explain_desc, ",
			"is_infomation_explain, is_health_hazard_solution, ", "health_hazard, solution, ",
			"status, updated_by, updated_on, ", "ip_address)",
			"values (#{id,jdbcType=BIGINT}, #{code,jdbcType=VARCHAR}, ",
			"#{py,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, #{idx,jdbcType=INTEGER}, ",
			"#{description,jdbcType=VARCHAR}, #{deptTypeId,jdbcType=INTEGER}, ",
			"#{operateDesc,jdbcType=VARCHAR}, #{provenance,jdbcType=VARCHAR}, ",
			"#{limitType,jdbcType=INTEGER}, #{explainDesc,jdbcType=VARCHAR}, ",
			"#{isInfomationExplain,jdbcType=INTEGER}, #{isHealthHazardSolution,jdbcType=INTEGER}, ",
			"#{healthHazard,jdbcType=VARCHAR}, #{solution,jdbcType=VARCHAR}, ",
			"#{status,jdbcType=INTEGER}, #{updatedBy,jdbcType=INTEGER}, #{updatedOn,jdbcType=TIMESTAMP}, ",
			"#{ipAddress,jdbcType=VARCHAR})" })
	int insert(Advice record);

	@InsertProvider(type = AdviceSqlProvider.class, method = "insertSelective")
	int insertSelective(Advice record);

	@Select({ "select", "id, code, py, name, idx, description, dept_type_id, operate_desc, provenance, ",
			"limit_type, explain_desc, is_infomation_explain, is_health_hazard_solution, ",
			"health_hazard, solution, if(status=1,1,0) as status, updated_by, updated_on, ip_address", "from c_advice",
			"where id = #{id,jdbcType=BIGINT} " })
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "code", property = "code", jdbcType = JdbcType.VARCHAR),
			@Result(column = "py", property = "py", jdbcType = JdbcType.VARCHAR),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "idx", property = "idx", jdbcType = JdbcType.INTEGER),
			@Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
			@Result(column = "dept_type_id", property = "deptTypeId", jdbcType = JdbcType.INTEGER),
			@Result(column = "operate_desc", property = "operateDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "provenance", property = "provenance", jdbcType = JdbcType.VARCHAR),
			@Result(column = "limit_type", property = "limitType", jdbcType = JdbcType.INTEGER),
			@Result(column = "explain_desc", property = "explainDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "is_infomation_explain", property = "isInfomationExplain", jdbcType = JdbcType.INTEGER),
			@Result(column = "is_health_hazard_solution", property = "isHealthHazardSolution", jdbcType = JdbcType.INTEGER),
			@Result(column = "health_hazard", property = "healthHazard", jdbcType = JdbcType.VARCHAR),
			@Result(column = "solution", property = "solution", jdbcType = JdbcType.VARCHAR),
			@Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
			@Result(column = "updated_by", property = "updatedBy", jdbcType = JdbcType.INTEGER),
			@Result(column = "updated_on", property = "updatedOn", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "ip_address", property = "ipAddress", jdbcType = JdbcType.VARCHAR) })
	Advice selectByPrimaryKey(Long id);

	@UpdateProvider(type = AdviceSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(Advice record);

	@Update({ "update c_advice", "set code = #{code,jdbcType=VARCHAR},", "py = #{py,jdbcType=VARCHAR},",
			"name = #{name,jdbcType=VARCHAR},", "idx = #{idx,jdbcType=INTEGER},",
			"description = #{description,jdbcType=VARCHAR},", "dept_type_id = #{deptTypeId,jdbcType=INTEGER},",
			"operate_desc = #{operateDesc,jdbcType=VARCHAR},", "provenance = #{provenance,jdbcType=VARCHAR},",
			"limit_type = #{limitType,jdbcType=INTEGER},", "explain_desc = #{explainDesc,jdbcType=VARCHAR},",
			"is_infomation_explain = #{isInfomationExplain,jdbcType=INTEGER},",
			"is_health_hazard_solution = #{isHealthHazardSolution,jdbcType=INTEGER},",
			"health_hazard = #{healthHazard,jdbcType=VARCHAR},", "solution = #{solution,jdbcType=VARCHAR},",
			"status = #{status,jdbcType=INTEGER},", "updated_by = #{updatedBy,jdbcType=INTEGER},",
			"updated_on = #{updatedOn,jdbcType=TIMESTAMP},", "ip_address = #{ipAddress,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(Advice record);

	@SelectProvider(type = AdviceSqlProvider.class, method = "selectAdvicesHandler")
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
			@Result(column = "dept_type_id", property = "deptTypeId", jdbcType = JdbcType.INTEGER),
			@Result(column = "updated_name", property = "updatedName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "department_name", property = "departmentName", jdbcType = JdbcType.VARCHAR), })
	List<AdviceView> selectAdvices(@Param("queryParam") AdviceParam queryParam);

	@SelectProvider(type = AdviceSqlProvider.class, method = "selectView")
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "code", property = "code", jdbcType = JdbcType.VARCHAR),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "description", property = "content", jdbcType = JdbcType.VARCHAR) })
	List<AdviceComboBoxView> selectView(@Param("departmentId") String departmentId);
}
