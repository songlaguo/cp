package org.bc.common.vo;

import java.io.Serializable;

/**
 * www.rmworking.com/blog Table: r_user do_not_delete_during_merge 2018-04-24 11:22:18
 */
public class UserSession implements Serializable {
	private static final long serialVersionUID = 1243032039470130575L;
	private Integer id;
	private String logonid;
	private String name;
	private Integer gender;
	private String workno;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogonid() {
		return logonid;
	}

	public void setLogonid(String logonid) {
		this.logonid = logonid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getWorkno() {
		return workno;
	}

	public void setWorkno(String workno) {
		this.workno = workno;
	}
}
