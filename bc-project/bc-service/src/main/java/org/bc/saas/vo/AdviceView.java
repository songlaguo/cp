package org.bc.saas.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author gjf
 * @create 2018/6/21.
 */
public class AdviceView {
    private Long id;
    @ApiModelProperty(value = "编码")
    private String code;
    @ApiModelProperty(value = "拼音")
    private String py;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "显示顺序")
    private Integer idx;
    @ApiModelProperty(value = "建议内容")
    private String description;
    @ApiModelProperty(value = "部门类别id")
    private Integer deptTypeId;
    @ApiModelProperty(value = "操作说明")
    private String operateDesc;
    @ApiModelProperty(value = "出处")
    private String provenance;
    @ApiModelProperty(value = "是否为限制项目")
    private Integer limitType;
    @ApiModelProperty(value = "名词解释")
    private String explainDesc;
    @ApiModelProperty(value = "报表中是否需要展示该名词解释")
    private Integer isInfomationExplain;
    @ApiModelProperty(value = "是否具有健康危害和解决方案")
    private Integer isHealthHazardSolution;
    @ApiModelProperty(value = "健康危害")
    private String healthHazard;
    @ApiModelProperty(value = "解决方案")
    private String solution;
    @ApiModelProperty(value = "状态")
    private Integer status;
    @ApiModelProperty(value = "操作人")
    private Integer updatedBy;
    @ApiModelProperty(value = "操作时间")
    private Date updatedOn;
    @ApiModelProperty(value = "ip")
    private String ipAddress;
    @ApiModelProperty(value = "科室类型名称")
    private String departmentName;
    @ApiModelProperty(value = "修改人")
    private String updatedName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPy() {
        return py;
    }

    public void setPy(String py) {
        this.py = py;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDeptTypeId() {
        return deptTypeId;
    }

    public void setDeptTypeId(Integer deptTypeId) {
        this.deptTypeId = deptTypeId;
    }

    public String getOperateDesc() {
        return operateDesc;
    }

    public void setOperateDesc(String operateDesc) {
        this.operateDesc = operateDesc;
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    public Integer getLimitType() {
        return limitType;
    }

    public void setLimitType(Integer limitType) {
        this.limitType = limitType;
    }

    public String getExplainDesc() {
        return explainDesc;
    }

    public void setExplainDesc(String explainDesc) {
        this.explainDesc = explainDesc;
    }

    public Integer getIsInfomationExplain() {
        return isInfomationExplain;
    }

    public void setIsInfomationExplain(Integer isInfomationExplain) {
        this.isInfomationExplain = isInfomationExplain;
    }

    public Integer getIsHealthHazardSolution() {
        return isHealthHazardSolution;
    }

    public void setIsHealthHazardSolution(Integer isHealthHazardSolution) {
        this.isHealthHazardSolution = isHealthHazardSolution;
    }

    public String getHealthHazard() {
        return healthHazard;
    }

    public void setHealthHazard(String healthHazard) {
        this.healthHazard = healthHazard;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getUpdatedName() {
        return updatedName;
    }

    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName;
    }
}
