package org.bc.mq.persistence.provider;

import org.apache.ibatis.jdbc.SQL;
import org.bc.common.entity.User;
import org.bc.common.utils.StringUtils;

 

public class UserSqlProvider {
	public String insertSelective(User record) {
		SQL sql = new SQL();
		sql.INSERT_INTO("r_user");
		if (record.getId() != null) {
			sql.VALUES("id", "#{id,jdbcType=INTEGER}");
		}
		if (record.getLogonid() != null) {
			sql.VALUES("logonid", "#{logonid,jdbcType=VARCHAR}");
		}
		if (record.getLogonPwd() != null) {
			sql.VALUES("logon_pwd", "#{logonPwd,jdbcType=VARCHAR}");
		}
		if (record.getName() != null) {
			sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
		}
		if (record.getGender() != null) {
			sql.VALUES("gender", "#{gender,jdbcType=INTEGER}");
		}
		if (record.getWorkno() != null) {
			sql.VALUES("workno", "#{workno,jdbcType=VARCHAR}");
		}
		if (record.getIdno() != null) {
			sql.VALUES("idno", "#{idno,jdbcType=VARCHAR}");
		}
		if (record.getMobile() != null) {
			sql.VALUES("mobile", "#{mobile,jdbcType=VARCHAR}");
		}
		if (record.getStatus() != null) {
			sql.VALUES("status", "#{status,jdbcType=INTEGER}");
		}
		if (record.getOrgId() != null) {
			sql.VALUES("org_id", "#{orgId,jdbcType=INTEGER}");
		}
		if (record.getCreatedBy() != null) {
			sql.VALUES("created_by", "#{createdBy,jdbcType=INTEGER}");
			sql.VALUES("updated_by", "#{createdBy,jdbcType=INTEGER}");
		}
		sql.VALUES("created_on", "now()");
		sql.VALUES("updated_on", "now()");
		if (record.getEhrUserId() != null) {
			sql.VALUES("ehr_user_id", "#{ehrUserId,jdbcType=CHAR}");
		}
		return sql.toString();
	}

	public String updateSelective(User record) {
		SQL sql = new SQL();
		sql.UPDATE("r_user");
		if (!StringUtils.isEmpty(record.getName())) {
			sql.SET("name = #{name,jdbcType=VARCHAR}");
		}
		if (!StringUtils.isEmpty(record.getLogonPwd())) {
			sql.SET("logon_pwd = #{logonPwd,jdbcType=VARCHAR}");
		}
		if (!StringUtils.isEmpty(record.getGender())) {
			sql.SET("gender = #{gender,jdbcType=INTEGER}");
		}
		if (!StringUtils.isEmpty(record.getMobile())) {
			sql.SET("mobile = #{mobile,jdbcType=VARCHAR}");
		}
		if (!StringUtils.isEmpty(record.getIdno())) {
			sql.SET("idno = #{idno,jdbcType=VARCHAR}");
		}
		if (record.getStatus() != null) {
			sql.SET("status = #{status,jdbcType=INTEGER}");
		}
		sql.SET("updated_by = #{updatedBy,jdbcType=INTEGER}");
		sql.SET("updated_on = now()");
		sql.WHERE("id = #{id,jdbcType=INTEGER}");
		return sql.toString();
	}
}
