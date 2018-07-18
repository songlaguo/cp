package org.bc.common.vo;

import java.io.Serializable;
import java.util.List;

import org.bc.common.entity.UserOrgPermission;
import org.bc.common.entity.UserOrgRole;

public class UserOrgPermissionView implements Serializable {
	private static final long serialVersionUID = -2357438380803087102L;
	// 用户组织
	private UserOrgPermission userOrgPermission;
	// 组织中的权限
	private List<UserOrgRole> userOrgRoleList;

	public UserOrgPermission getUserOrgPermission() {
		return userOrgPermission;
	}

	public void setUserOrgPermission(UserOrgPermission userOrgPermission) {
		this.userOrgPermission = userOrgPermission;
	}

	public List<UserOrgRole> getUserOrgRoleList() {
		return userOrgRoleList;
	}

	public void setUserOrgRoleList(List<UserOrgRole> userOrgRoleList) {
		this.userOrgRoleList = userOrgRoleList;
	}
}
