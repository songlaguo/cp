package org.bc.common.entity;

import org.bc.common.vo.Page;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author : R&M www.rmworking.com/blog
 *         2018/5/7 13:51
 *         saas-base-organization
 *         com.ikang.saas.base.vo
 */
public class OrgHospView extends Page implements Serializable {

    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 区域编码
     */
    private Integer areaCode;

    /**
     * 组织三个级别名称
     */
    private String level1;
    private String level2;
    private String level3;

    /**
     * 更新人
     */
    private Integer updatedBy;

    /**
     * 更新日期
     */
    private Timestamp updatedOn;

    /**
     * 父组织id
     */
    private Integer orgId;
    /**
     * 可用状态：0启用，1禁用
     */
    private Integer status;

    /**
     * 别名
     */
    private String byName;

    /**
     * 创建者
     */
    private String creatName;
    /**
     * 更新者
     */
    private String updatedName;
    private String code;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getByName() {
        return byName;
    }

    public void setByName(String byName) {
        this.byName = byName;
    }

    public String getLevel1() {
        return level1;
    }

    public void setLevel1(String level1) {
        this.level1 = level1;
    }

    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        this.level2 = level2;
    }

    public String getLevel3() {
        return level3;
    }

    public void setLevel3(String level3) {
        this.level3 = level3;
    }

    public String getCreatName() {
        return creatName;
    }

    public void setCreatName(String creatName) {
        this.creatName = creatName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUpdatedName() {
        return updatedName;
    }

    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName;
    }
}
