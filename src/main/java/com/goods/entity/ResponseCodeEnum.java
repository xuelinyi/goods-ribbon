package com.goods.entity;

import java.util.HashMap;
import java.util.Map;

public enum ResponseCodeEnum {
	/**
	 * 成功
	 */
	SUCCESS(0, "成功"),
	/**
	 * 参数错误
	 */
	PARMS_ERROR(1, "参数错误"),
	/**
	 * 用户需要登录
	 */
	LOGIN_ERROR(2, "登录超时，请重新登录"),
	/**
	 * 数据异常
	 */
	ABNORMAL_ERROR(3, "数据异常"),
	/**
	 * 操作失败
	 */
	OPTION_ERROR(4, "操作失败"),
	/**
	 * 未知错误
	 */
	UNKNOWN_ERROR(5, "未知错误"),
	/**
	 * 上传错误
	 */
	UPLOAD_ERROR(6, "上传错误"),
	
	/**
	 * 渠道错误
	 */
	PARMS_ERROR_CHANNEL(7, "渠道错误"),

	/**
	 *没有权限
	 */
	NO_PERMISSION(8, "没有权限"),

	/**
	 *手机号或者身份证重复
	 */
	DUPLICATE_PHONE_ID_CARD(9, "手机号或者身份证重复");

	final static private Map<Integer, ResponseCodeEnum> MAP = new HashMap<Integer, ResponseCodeEnum>() {
		private static final long serialVersionUID = -8414553247670306999L;
		{
			ResponseCodeEnum[] enums = ResponseCodeEnum.values();
			for (ResponseCodeEnum responseCodeEnum : enums) {
				put(responseCodeEnum.getCode(), responseCodeEnum);
			}
		}
	};

	public static ResponseCodeEnum getEnum(Integer code) {
		return MAP.get(code);
	}

	public static String getEnumDesc(Integer code) {
		ResponseCodeEnum responseCodeEnum = MAP.get(code);
		if (responseCodeEnum != null) {
			return responseCodeEnum.getMessage();
		}
		return "";
	}

	private Integer code;

	private String message;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private ResponseCodeEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
