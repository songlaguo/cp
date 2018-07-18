package org.bc.common.vo;

public class BaseAppResult implements java.io.Serializable {
	private static final long serialVersionUID = -6672505284372253869L;

	/**
	 * 模拟http status code建立业务返回码
	 * 业务操作成功码：2000 +
	 * 业务操作失败码：5000 +
	 */
	private static final int SUCCESS= 2000;
	private static final String SUCCESS_MESSAGE= "成功";
	private static final int FAILURE= 5000;
	private static final String FAILURE_MESSAGE= "失败";
	private static final int ERROR= 500;

	private int code;
	private String message;
	private String errors;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}

	public void succeed(){
		this.code = SUCCESS;
		this.message = SUCCESS_MESSAGE;
	}

	public void fail(){
		this.code = FAILURE;
		this.message = FAILURE_MESSAGE;
	}
}
