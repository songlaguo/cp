package org.bc.mq.persistence.provider;

 
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.bc.common.entity.UserOrgPermission;
import org.bc.common.vo.Constant;

import java.util.Objects;

public class UserOrgPermissionSqlProvider {

    public String selectExpressByUserIdAndLevel(@Param("userId") Integer userId, @Param("level") Integer level){
        SQL sql = new SQL();
        if (Objects.equals(level , Constant.FIRST_LEVEL)){
            sql.SELECT("DISTINCT SUBSTRING_INDEX(express, '/', 1)");
        }
        if (Objects.equals(level , Constant.SECOND_LEVEL)){
            sql.SELECT("DISTINCT SUBSTRING_INDEX(SUBSTRING_INDEX(express,'/',2),'/',-1)");
        }
        if (Objects.equals(level , Constant.THIRD_LEVEL)){
            sql.SELECT("DISTINCT SUBSTRING_INDEX(SUBSTRING_INDEX(express,'/',3),'/',-1)");
        }
        sql.FROM("r_user_org_permission");
        sql.WHERE("user_id = #{userId}");
        return sql.toString();
    }

	public String insertSelective(UserOrgPermission record) {
		SQL sql = new SQL();
		sql.INSERT_INTO("r_user_org_permission");
		if (record.getId() != null) {
			sql.VALUES("id", "#{id,jdbcType=INTEGER}");
		}
		if (record.getStatus() != null) {
			sql.VALUES("status", "#{status,jdbcType=INTEGER}");
		}
		if (record.getExpress() != null) {
			sql.VALUES("express", "#{express,jdbcType=VARCHAR}");
		}
		if (record.getCreatedBy() != null) {
			sql.VALUES("created_by", "#{createdBy,jdbcType=INTEGER}");
			sql.VALUES("updated_by", "#{createdBy,jdbcType=INTEGER}");
		}
		sql.VALUES("created_on", "now()");
		sql.VALUES("updated_on", "now()");
		if (record.getOrgId() != null) {
			sql.VALUES("org_id", "#{orgId,jdbcType=INTEGER}");
		}
		if (record.getUserId() != null) {
			sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
		}
		return sql.toString();
	}

	public String updateByPrimaryKeySelective(UserOrgPermission record) {
		SQL sql = new SQL();
		sql.UPDATE("r_user_org_permission");
		if (record.getStatus() != null) {
			sql.SET("status = #{status,jdbcType=INTEGER}");
		}
		if (record.getExpress() != null) {
			sql.SET("express = #{express,jdbcType=VARCHAR}");
		}
		if (record.getOrgId() != null) {
			sql.SET("org_id = #{orgId,jdbcType=INTEGER}");
		}
		if (record.getUserId() != null) {
			sql.SET("user_id = #{userId,jdbcType=INTEGER}");
		}
		sql.SET("updated_by = #{updatedBy,jdbcType=INTEGER}");
		sql.SET("updated_on = now()");
		sql.WHERE("id = #{id,jdbcType=INTEGER}");
		return sql.toString();
	}
}
