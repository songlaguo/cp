package org.bc.mq.vo;

import java.io.Serializable;

public class MisEmployee implements Serializable {
	private static final long serialVersionUID = 5059353498779389311L;
	private Long id; // Mis id
	private String ehrId; // 集团ehr id
	private String ehrCode; // 集团ehr 工号
	private String name; // 员工姓名
	private String password; // 密码
	private Integer gender; // 性别 （1男、0女、2未知）
	private String addr; //
	private String idCard; //
	private String mobile; //
	private String birthday; //
	private String empType; // 员工类型
	private String corp; //
	private String deptCode; //
	private String areaCode; //
	private String[] supportedHosps;// 支持分院
	private MisEmployeeSkill[] skills; // 职业技能

	public Long getId() {
		return id;
	}

	public void setId(Long misId) {
		this.id = misId;
	}

	public String getEhrId() {
		return ehrId;
	}

	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}

	public String getEhrCode() {
		return ehrCode;
	}

	public void setEhrCode(String ehrCode) {
		this.ehrCode = ehrCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public String getCorp() {
		return corp;
	}

	public void setCorp(String corp) {
		this.corp = corp;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String[] getSupportedHosps() {
		return supportedHosps;
	}

	public void setSupportedHosps(String[] supportedHospitals) {
		this.supportedHosps = supportedHospitals;
	}

	public MisEmployeeSkill[] getSkills() {
		return skills;
	}

	public void setSkills(MisEmployeeSkill[] skills) {
		this.skills = skills;
	}
}
