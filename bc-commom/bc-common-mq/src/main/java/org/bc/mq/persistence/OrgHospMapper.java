package org.bc.mq.persistence;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.bc.common.driver.MybatisSelectInExtendedLanguageDriver;
import org.bc.common.entity.OrgHospView;
import org.bc.mq.persistence.entity.OrgHosp;
import org.bc.mq.persistence.provider.OrgHospSqlProvider;
import org.springframework.stereotype.Repository;

 

@Mapper
@Repository
public interface OrgHospMapper {
	@InsertProvider(type = OrgHospSqlProvider.class, method = "insertSelective")
	int insertSelective(OrgHosp record);

	/**
	 * 根据ID查询节点
	 * @param id
	 * @param orgId
	 * @return
	 */
	@SelectProvider(type = OrgHospSqlProvider.class, method = "selectById")
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "level1", property = "level1", jdbcType = JdbcType.VARCHAR),
			@Result(column = "level2", property = "level2", jdbcType = JdbcType.VARCHAR),
			@Result(column = "level3", property = "level3", jdbcType = JdbcType.VARCHAR),
			@Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
			@Result(column = "by_name", property = "byName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updated_by", property = "updatedBy", jdbcType = JdbcType.INTEGER),
			@Result(column = "updated_on", property = "updatedOn", jdbcType = JdbcType.TIMESTAMP) })
	OrgHospView selectById(@Param("id") Integer id, @Param("orgId") String orgId);

	@UpdateProvider(type = OrgHospSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(OrgHosp record);

	/**
	 * 根据orgId查询顶级菜单
	 * @return
	 */
	@Select("select id , `name` from c_org_hosp where level = 1 and status = 0")
	List<OrgHospView> selectTopOrgHospByIds();

	/**
	 * 根据orgId查询子集菜单
	 * @param orgId
	 * @param level
	 * @return
	 */
	@Select("select id , IF(`level` = 3 , IF(by_name='' or by_name is null,`name`,by_name),`name`) as `name` from c_org_hosp where org_id = #{orgId} and level = #{level} and status = 0")
	List<OrgHospView> selectChildrenOrgHospByOrgHospId(@Param("orgId") Integer orgId, @Param("level") Integer level);

	/**
	 * 根据多个id进行查询
	 * @param pId
	 * @param ids
	 * @return
	 */
	@Lang(MybatisSelectInExtendedLanguageDriver.class)
	@Select("select id , IF(`level` = 3,IF(by_name='' or by_name is null,`name`,by_name),`name`) as `name` from c_org_hosp where status = 0 and id in (#{ids}) if org_id = #{pId}")
	List<OrgHospView> selectOrgHospByIds(@Param("pId") Integer pId, @Param("ids") List<String> ids);

	/**
	 * 查询组织名称
	 * @param id
	 * @return
	 */
	@Select("select if((level=3 and (by_name is not null and by_name !='')),by_name,name) as name from c_org_hosp where id=#{id}")
	String selectOrgName(@Param("id") Integer id);

	/**
	 * 查询组织名称
	 * @param id
	 * @return
	 */
	@Select("select case when coh.level=3 then CONCAT((select m.org_id from c_org_hosp m where m.id=coh.org_id),'/',coh.org_id,'/',coh.id,'/')"
			+ "when coh.level=2 then CONCAT(coh.org_id,'/',coh.id,'/')" + "when coh.level=1 then CONCAT(coh.id,'/')"
			+ "end as expree from c_org_hosp coh where coh.id=#{id}")
	String selectOrgExpress(@Param("id") Integer id);
}
