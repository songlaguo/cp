package org.bc.common.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SelectRoleView")
public class SelectRoleView implements Serializable {
	private static final long serialVersionUID = 5952067588408258079L;
	@ApiModelProperty(value = "组织机构信息", required = true)
	private String express;
	@ApiModelProperty(value = "角色id", required = true)
	private Integer roleId;
	@ApiModelProperty(value = "房间号id", required = true)
	private Integer roomId;

	public String getExpress() {
		return express;
	}

	public void setExpress(String express) {
		this.express = express;
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
