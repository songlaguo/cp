package org.bc.saas.mq.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.bc.saas.common.entity.UserOrgPermission;
import org.bc.saas.mq.persistence.provider.UserOrgPermissionSqlProvider;
import org.springframework.stereotype.Repository;

 

@Mapper
@Repository
public interface UserOrgPermissionMapper {
	@Delete({ "delete from r_user_org_permission", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	@Insert({ "insert into r_user_org_permission (id, status, ", "express, created_by, ", "updated_by, created_on, ",
			"updated_on, org_id, ", "user_id)", "values (#{id,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
			"#{express,jdbcType=VARCHAR}, #{createdBy,jdbcType=INTEGER}, ",
			"#{updatedBy,jdbcType=INTEGER}, #{createdOn,jdbcType=TIMESTAMP}, ",
			"#{updatedOn,jdbcType=TIMESTAMP}, #{orgId,jdbcType=INTEGER}, ", "#{userId,jdbcType=INTEGER})" })
	int insert(UserOrgPermission record);

	@InsertProvider(type = UserOrgPermissionSqlProvider.class, method = "insertSelective")
	@Options(useGeneratedKeys = true, keyColumn = "id")
	int insertSelective(UserOrgPermission record);

	@Select({ "select", "id, status, express, created_by, updated_by, created_on, updated_on, org_id, user_id",
			"from r_user_org_permission", "where id = #{id,jdbcType=INTEGER}" })
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
			@Result(column = "express", property = "express", jdbcType = JdbcType.VARCHAR),
			@Result(column = "created_by", property = "createdBy", jdbcType = JdbcType.INTEGER),
			@Result(column = "updated_by", property = "updatedBy", jdbcType = JdbcType.INTEGER),
			@Result(column = "created_on", property = "createdOn", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "updated_on", property = "updatedOn", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "org_id", property = "orgId", jdbcType = JdbcType.INTEGER),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER) })
	UserOrgPermission selectByPrimaryKey(Integer id);

	@UpdateProvider(type = UserOrgPermissionSqlProvider.class, method = "updateByPrimaryKeySelective")
	@Options(useGeneratedKeys = true, keyColumn = "id")
	int updateByPrimaryKeySelective(UserOrgPermission record);

	@Update({ "update r_user_org_permission", "set status = #{status,jdbcType=INTEGER},",
			"express = #{express,jdbcType=VARCHAR},", "created_by = #{createdBy,jdbcType=INTEGER},",
			"updated_by = #{updatedBy,jdbcType=INTEGER},", "created_on = #{createdOn,jdbcType=TIMESTAMP},",
			"updated_on = #{updatedOn,jdbcType=TIMESTAMP},", "org_id = #{orgId,jdbcType=INTEGER},",
			"user_id = #{userId,jdbcType=INTEGER}", "where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(UserOrgPermission record);

	@Select({ "SELECT uop.id, uop.status, uop.express, uop.updated_by, uop.updated_on, uop.org_id, uop.user_id"
			+ " FROM r_user_org_permission uop WHERE uop.user_id=#{userId} AND status='0'" })
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
			@Result(column = "express", property = "express", jdbcType = JdbcType.VARCHAR),
			@Result(column = "created_by", property = "createdBy", jdbcType = JdbcType.INTEGER),
			@Result(column = "updated_by", property = "updatedBy", jdbcType = JdbcType.INTEGER),
			@Result(column = "created_no", property = "createdNo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "created_on", property = "createdOn", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "updated_on", property = "updatedOn", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "org_id", property = "orgId", jdbcType = JdbcType.INTEGER),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER) })
	List<UserOrgPermission> getUserOrgPermissions(@Param("userId") Integer userId);

	@Select({ "SELECT uop.id, uop.status, uop.express, uop.updated_by, uop.updated_on, uop.org_id, uop.user_id"
			+ ",(case uop.created_by when 0 then 'admin' else (SELECT logonid FROM r_user WHERE id = uop.created_by) end) AS created_no"
			+ ",IF(uop.express LIKE CONCAT(#{express},'%'),1,0) as en_edit "
			+ ", IF((SELECT org_id FROM r_user WHERE id=uop.`user_id`)=uop.`org_id`,0,1) AS org_en_edit"
			+ " FROM r_user_org_permission uop WHERE uop.user_id=#{userId} AND status='0'" })
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
			@Result(column = "express", property = "express", jdbcType = JdbcType.VARCHAR),
			@Result(column = "created_by", property = "createdBy", jdbcType = JdbcType.INTEGER),
			@Result(column = "updated_by", property = "updatedBy", jdbcType = JdbcType.INTEGER),
			@Result(column = "created_no", property = "createdNo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "created_on", property = "createdOn", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "updated_on", property = "updatedOn", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "org_id", property = "orgId", jdbcType = JdbcType.INTEGER),
			@Result(column = "en_edit", property = "enEdit", jdbcType = JdbcType.INTEGER),
			@Result(column = "org_en_edit", property = "orgEnEdit", jdbcType = JdbcType.INTEGER),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER) })
	List<UserOrgPermission> getUserOrgPermissionsWhitExpress(@Param("userId") Integer userId,
			@Param("express") String express);

	/**
	 * 获取组织三级下拉ID
	 * @param userId
	 * @param level
	 * @return
	 */
	@SelectProvider(type = UserOrgPermissionSqlProvider.class, method = "selectExpressByUserIdAndLevel")
	List<String> selectExpressByUserIdAndLevel(@Param("userId") Integer userId, @Param("level") Integer level);

	@Select({ "SELECT id FROM r_user_org_permission WHERE user_id =#{userId} AND express=#{express} LIMIT 1 " })
	Integer getUserOrgPermissionsByUserIdAndOrgId(@Param("userId") Integer userId, @Param("express") String express);
}
