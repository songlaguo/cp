package org.bc.common.vo;

import java.io.Serializable;

public class DictView implements Serializable{
	/**
	
	 * @fieldName: serialVersionUID
	
	 * @fieldType: long
	
	 * @Description: 
	
	 */
	private static final long serialVersionUID = 103712762428457866L;
	private Integer id;
	private String code;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
