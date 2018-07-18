package org.bc.common.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SelectRoleParm")
public class SelectRoleParm implements Serializable {
	private static final long serialVersionUID = 8299284593543877312L;
	@ApiModelProperty(value = "一级组织id", required = true)
	private Integer fistLevelId;
	@ApiModelProperty(value = "二级组织id", required = true)
	private Integer secondLevelId;
	@ApiModelProperty(value = "三级组织id", required = true)
	private Integer thirdLevelId;
	@ApiModelProperty(value = "角色id", required = true)
	private Integer roleId;
	@ApiModelProperty(value = "房间号id", required = true)
	private Integer roomId;

	public Integer getFistLevelId() {
		return fistLevelId;
	}

	public void setFistLevelId(Integer fistLevelId) {
		this.fistLevelId = fistLevelId;
	}

	public Integer getSecondLevelId() {
		return secondLevelId;
	}

	public void setSecondLevelId(Integer secondLevelId) {
		this.secondLevelId = secondLevelId;
	}

	public Integer getThirdLevelId() {
		return thirdLevelId;
	}

	public void setThirdLevelId(Integer thirdLevelId) {
		this.thirdLevelId = thirdLevelId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
}
