package org.bc.saas.mq.persistence;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.bc.saas.common.entity.User;
import org.bc.saas.mq.persistence.provider.UserSqlProvider;
import org.springframework.stereotype.Repository;

 

@Mapper
@Repository
public interface UserMapper {
	@Delete({ "delete from r_user", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	@Insert({ "insert into r_user (id, logonid, ", "logon_pwd, name, ", "gender, workno, ", "idno, mobile, status, ",
			"org_id, created_by, ", "updated_by, created_on, ", "updated_on, ehr_user_id)",
			"values (#{id,jdbcType=INTEGER}, #{logonid,jdbcType=VARCHAR}, ",
			"#{logonPwd,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
			"#{gender,jdbcType=INTEGER}, #{workno,jdbcType=VARCHAR}, ",
			"#{idno,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
			"#{orgId,jdbcType=INTEGER}, #{createdBy,jdbcType=INTEGER}, ",
			"#{updatedBy,jdbcType=INTEGER}, #{createdOn,jdbcType=TIMESTAMP}, ",
			"#{updatedOn,jdbcType=TIMESTAMP}, #{ehrUserId,jdbcType=CHAR})" })
	int insert(User record);

	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	@InsertProvider(type = UserSqlProvider.class, method = "insertSelective")
	int insertSelective(User record);

	@UpdateProvider(type = UserSqlProvider.class, method = "updateSelective")
	int updateByPrimaryKeySelective(User record);

	@Update({ "update r_user", "set logonid = #{logonid,jdbcType=VARCHAR},",
			"logon_pwd = #{logonPwd,jdbcType=VARCHAR},", "name = #{name,jdbcType=VARCHAR},",
			"gender = #{gender,jdbcType=INTEGER},", "workno = #{workno,jdbcType=VARCHAR},",
			"idno = #{idno,jdbcType=VARCHAR},", "mobile = #{mobile,jdbcType=VARCHAR},",
			"status = #{status,jdbcType=INTEGER},", "org_id = #{orgId,jdbcType=INTEGER},",
			"created_by = #{createdBy,jdbcType=INTEGER},", "updated_by = #{updatedBy,jdbcType=INTEGER},",
			"created_on = #{createdOn,jdbcType=TIMESTAMP},", "updated_on = #{updatedOn,jdbcType=TIMESTAMP},",
			"ehr_user_id = #{ehrUserId,jdbcType=CHAR}", "where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(User record);

	@Select("select id from r_user where ehr_user_id = #{ehrUserId}")
	Integer selectByEhrUserId(@Param("ehrUserId") String ehrUserId);
}
