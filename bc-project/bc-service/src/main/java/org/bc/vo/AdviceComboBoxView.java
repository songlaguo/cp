package org.bc.vo;

import java.io.Serializable;

public class AdviceComboBoxView implements Serializable {
	private static final long serialVersionUID = 8874731541657598732L;
	private Long id;
	private String code;
	private String name;
	private String content;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
