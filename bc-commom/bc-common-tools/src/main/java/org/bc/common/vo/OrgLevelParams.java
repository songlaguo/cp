package org.bc.common.vo;

import java.io.Serializable;

/**
 * @author Jalon
 * @Description:
 * @create 2018/05/16 - 15:06
 * @package com.ikang.saas.rbac.vo
 */
public class OrgLevelParams implements Serializable {
	private Integer orgIdOne;
	private Integer orgIdTwo;
	private Integer orgIdThree;

	public Integer getOrgIdOne() {
		return orgIdOne;
	}

	public void setOrgIdOne(Integer orgIdOne) {
		this.orgIdOne = orgIdOne;
	}

	public Integer getOrgIdTwo() {
		return orgIdTwo;
	}

	public void setOrgIdTwo(Integer orgIdTwo) {
		this.orgIdTwo = orgIdTwo;
	}

	public Integer getOrgIdThree() {
		return orgIdThree;
	}

	public void setOrgIdThree(Integer orgIdThree) {
		this.orgIdThree = orgIdThree;
	}
}
