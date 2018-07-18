package org.bc.mq.persistence.provider;

import java.util.List;

import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.bc.common.driver.MybatisSelectInExtendedLanguageDriver;
import org.bc.mq.persistence.entity.OrgHosp;

 

public class OrgHospSqlProvider {
	@Lang(MybatisSelectInExtendedLanguageDriver.class)
	public String selectOrgHospByIds(@Param("pId") Integer pId, @Param("ids") List<String> ids) {
		SQL sql = new SQL();
		sql.SELECT("id", "`name`");
		sql.FROM("c_org_hosp");
		sql.WHERE(" status = 0 ");
		sql.WHERE("id in (#{ids})");
		if (pId != null) {
			sql.WHERE(" org_id = #{pId}");
		}
		return sql.toString();
	}

	public String selectById(@Param("id") Integer id, @Param("orgId") String orgId) {
		SQL sql = new SQL();
		sql.SELECT("c4.id", "c3.level1", "c3.level2", "c4.`name` as level3", "c4.by_name", "c4.`status`",
				"c4.updated_by", "c4.updated_on");
		sql.FROM("(select c1.id AS id1 ,c1.`name`as level1 ,c2.id AS id2 ,c2.org_id,c2.`name` as level2 \n"
				+ "from c_org_hosp c1 INNER join c_org_hosp c2 on c1.id=c2.org_id where c1.`level`=1) c3");
		sql.INNER_JOIN("c_org_hosp c4 on c3.id2=c4.org_id");
		sql.WHERE("id = #{id}");
		if (orgId != null) {
			sql.WHERE("CONCAT(c3.id1 ,'/',c3.id2,'/',c4.id ,'/') like CONCAT(#{orgId},'%')");
		}
		return sql.toString();
	}

	public String insertSelective(OrgHosp record) {
		SQL sql = new SQL();
		sql.INSERT_INTO("c_org_hosp");
		if (record.getId() != null) {
			sql.VALUES("id", "#{id,jdbcType=INTEGER}");
		}
		if (record.getName() != null) {
			sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
		}
		if (record.getAreaCode() != null) {
			sql.VALUES("area_code", "#{areaCode,jdbcType=INTEGER}");
		}
		if (record.getLevel() != null) {
			sql.VALUES("level", "#{level,jdbcType=INTEGER}");
		}
		if (record.getCreatedBy() != null) {
			sql.VALUES("created_by", "#{createdBy,jdbcType=INTEGER}");
		}
		if (record.getUpdatedBy() != null) {
			sql.VALUES("updated_by", "#{updatedBy,jdbcType=INTEGER}");
		}
		sql.VALUES("created_on", "now()");
		sql.VALUES("updated_on", "now()");
		if (record.getOrgId() != null) {
			sql.VALUES("org_id", "#{orgId,jdbcType=INTEGER}");
		}
		if (record.getStatus() != null) {
			sql.VALUES("status", "#{status}");
		}
		if (record.getByName() != null) {
			sql.VALUES("by_name", "#{byName}");
		}
		if (record.getUnitCode() != null) {
			sql.VALUES("unit_code", "#{unitCode}");
		}
		return sql.toString();
	}

	public String updateByPrimaryKeySelective(OrgHosp record) {
		SQL sql = new SQL();
		sql.UPDATE("c_org_hosp");
		if (record.getName() != null) {
			sql.SET("name = #{name,jdbcType=VARCHAR}");
		}
		if (record.getAreaCode() != null) {
			sql.SET("area_code = #{areaCode,jdbcType=INTEGER}");
		}
		if (record.getLevel() != null) {
			sql.SET("level = #{level,jdbcType=INTEGER}");
		}
		if (record.getCreatedBy() != null) {
			sql.SET("created_by = #{createdBy,jdbcType=INTEGER}");
		}
		if (record.getUpdatedBy() != null) {
			sql.SET("updated_by = #{updatedBy,jdbcType=INTEGER}");
		}
		sql.SET("updated_on = now()");
		if (record.getOrgId() != null) {
			sql.SET("org_id = #{orgId,jdbcType=INTEGER}");
		}
		if (record.getStatus() != null) {
			sql.SET("status = #{status}");
		}
		if (record.getByName() != null) {
			sql.SET("by_name = #{byName}");
		}
		if (record.getUnitCode() != null) {
			sql.SET("unit_code = #{unitCode}");
		}
		sql.WHERE("id = #{id,jdbcType=INTEGER}");
		return sql.toString();
	}
}
