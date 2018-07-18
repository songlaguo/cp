/**
 * 
 */
package org.bc.mq.vo;

/**
 * @author andy.zhang
 *
 */
public class MisEmployeeSkill {
	
	private String skillCode;
	private String name;
	private String ehrSkillId;
	private Long employeeId;
	
	
	public String getSkillCode() {
		return skillCode;
	}
	public void setSkillCode(String skillCode) {
		this.skillCode = skillCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEhrSkillId() {
		return ehrSkillId;
	}
	public void setEhrSkillId(String ehrSkillId) {
		this.ehrSkillId = ehrSkillId;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	
}
