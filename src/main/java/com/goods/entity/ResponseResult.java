package com.goods.entity;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {
	private final long serialVersionUID = 1L;

	/**
	 * 返回code码
	 */
	private Integer code;

	/**
	 * 返回备注信息
	 */
	private String message;

	/**
	 * 返回数据
	 */
	private T data;

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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ResponseResult() {
	}

	public ResponseResult(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public ResponseResult(Integer code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public ResponseResult<T> success(String message, T data) {
		this.code = ResponseCodeEnum.SUCCESS.getCode();
		this.message = message;
		this.data = data;
		return this;
	}

	public ResponseResult<T> success() {
		return success(ResponseCodeEnum.SUCCESS.getMessage(), null);
	}

	public ResponseResult<T> success(T data) {
		return success(ResponseCodeEnum.SUCCESS.getMessage(), data);
	}

	public ResponseResult<T> error(Integer code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
		return this;
	}

	public ResponseResult<T> error() {
		return error(ResponseCodeEnum.UNKNOWN_ERROR.getMessage(), null);
	}

	public ResponseResult<T> error(Integer code, String message) {
		code = code == null ? ResponseCodeEnum.UNKNOWN_ERROR.getCode() : code;
		return error(code, message, null);
	}

	public ResponseResult<T> error(String message) {
		return error(message, null);
	}

	public ResponseResult<T> error(T data) {
		return error(ResponseCodeEnum.UNKNOWN_ERROR.getMessage(), data);
	}

	public ResponseResult<T> error(String message, T data) {
		return error(ResponseCodeEnum.UNKNOWN_ERROR.getCode(), message, data);
	}

	public ResponseResult<T> error(ResponseCodeEnum responseCodeEnum) {
		return error(responseCodeEnum.getCode(), responseCodeEnum.getMessage(), null);
	}
}
