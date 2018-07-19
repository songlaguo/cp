/**
 * Copyright (c) 2014 ShanghaiMed iKang,Inc. All rights reserved.
 */
package org.bc.saas.common.vo;

/**
 * 本地项目常量定义.
 */
public class Constant {
	/**
	 * 返回状态码
	 */
	public static enum ACCESS_CODE {
		/**
		 * 状态码枚举
		 */
		SUCCESS(1, "操作成功"), FAILED(2, "操作失败"), DENIED(3, "拒绝访问"), TIMEOUT(4, "登录超时，请重新登录!"), ERROR(5, "账户密码错误超过5次");
		private int code;
		private String name;

		private ACCESS_CODE(int code, String name) {
			this.code = code;
			this.name = name;
		}

		public int getCode() {
			return code;
		}

		public String getName() {
			return name;
		}
	}

	/**
	 * 返回内容
	 */
	public static enum RETURN_MSG {
		/**
		 * 内容码枚举
		 */
		NOMAL(1, "成功!"), TIMEOUT(2, "登录超时，请重新登录!"), FAILED(3, "获取数据失败!");
		private int code;
		private String name;

		private RETURN_MSG(int code, String name) {
			this.code = code;
			this.name = name;
		}

		public int getCode() {
			return code;
		}

		public String getName() {
			return name;
		}
	}

	/**
	 * 登录信息
	 */
	public static final String LOGIN_STATE = "LOGIN_STATE";
	/**
	 * resource表分类 资源分类
	 */
	public static final Integer RESOURCE_CATE_CODE = 1;
	public static final Integer DEPARTMENT_CATE_CODE = 2;
	/**
	 * status分类0启用,1停用 后序改成0：停用，1：启用
	 */
	public static final Integer STATUS_DISABLE = 0;
	public static final Integer STATUS_ENABLE = 1;
	/**
	 * 枚举 0false 1true
	 */
	public static final Integer ENUM_FALSE = 0;
	public static final Integer ENUM_TRUE = 1;
	/**
	 * 性别编码0女1男2不详
	 */
	public static final Integer GENDER_CODE_FEMALE = 0;
	public static final Integer GENDER_CODE_MALE = 1;
	public static final Integer GENDER_CODE_UNKNOW = 2;
	/**
	 * 检查类型的类别 0挂号1体检2口腔
	 */
	public static final Integer EXAM_TYPE_REGISTER = 0;
	public static final Integer EXAM_TYPE_CHECK = 1;
	public static final Integer EXAM_TYPE_NONNASALITY = 2;
	/**
	 * 设备类型类别 0检验设备 1检查设备
	 */
	public static final Integer EXAM_DEVICE_TYPE0 = 0;
	public static final Integer EXAM_DEVICE_TYPE1 = 1;
	/**
	 * 审核状态 0待审核1通过2不通过
	 */
	public static final Integer AUDIT_STATUS_UNCHECKED = 0;
	public static final Integer AUDIT_STATUS_PASS = 1;
	public static final Integer AUDIT_STATUS_UNPASS = 2;
	/**
	 * 目录层级
	 */
	public static final Integer FIRST_LEVEL = 1;
	public static final Integer SECOND_LEVEL = 2;
	public static final Integer THIRD_LEVEL = 3;
	/**
	 * 用户角色选择
	 */
	public static final String USER_ROLE = "USER_ROLE";
	/**
	 * 默认密码
	 */
	public static final String USER_PSW_RESET = "123456";
	/**
	 * EHR用户来源标识
	 */
	public static final String SOURCE_EHR = "EHR";
	/**
	 * saas创建用户默认无组织id
	 */
	public static final Integer SAAS_USER_DEFULT_ORGID = 1;
	/**
	 * 加密数据的盐
	 */
	public static final String DATA_SALT = "ikang_saas%&(+||";
	/**
	 * 在redis中记录组织数据修改的最后时间
	 */
	public static final String ORG_DATE_REDIS = "ORG_DATE_REDIS";
	/**
	 * 在redis中记录组织数据修改的最后修改人
	 */
	public static final String ORG_NAME_REDIS = "ORG_NAME_REDIS";
	/**
	 * 检中start
	 */
	public static final String DEPARTMENT_EXAMINATION = "department_examination";
	public static final String DEPARTMENT_EXAMINATION_INSTITUTE_ID = "institute_id";
	public static final String DEPARTMENT_EXAMINATION_DEPARTMENT_ID = "department_id";
	public static final String DEPARTMENT_EXAMINATION_DEPARTMENT_NAME = "department_name";
	public static final String WHERE_ACCOUNTS_ACCOUNTTYPE = "accounts.accountType";
	public static final String LOCATOR_ACCOUNTS_BALANCE = "accounts.$.balance";
	/**
	 * 检中end
	 */
}
