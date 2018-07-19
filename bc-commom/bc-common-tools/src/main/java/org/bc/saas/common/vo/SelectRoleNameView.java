package org.bc.saas.common.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class SelectRoleNameView implements Serializable {
	private static final long serialVersionUID = -1672665446660991493L;
	@ApiModelProperty(value = "一级组织name", required = true)
	private String fistLevelName;
	@ApiModelProperty(value = "二级组织Name", required = true)
	private String secondLevelName;
	@ApiModelProperty(value = "三级组织Name", required = true)
	private String thirdLevelName;
	@ApiModelProperty(value = "角色Name", required = true)
	private String roleName;

	public String getFistLevelName() {
		return fistLevelName;
	}

	public void setFistLevelName(String fistLevelName) {
		this.fistLevelName = fistLevelName;
	}

	public String getSecondLevelName() {
		return secondLevelName;
	}

	public void setSecondLevelName(String secondLevelName) {
		this.secondLevelName = secondLevelName;
	}

	public String getThirdLevelName() {
		return thirdLevelName;
	}

	public void setThirdLevelName(String thirdLevelName) {
		this.thirdLevelName = thirdLevelName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
