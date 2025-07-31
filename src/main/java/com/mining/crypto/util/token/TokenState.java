package com.mining.crypto.util.token;

public enum TokenState {

	/**
	 * token过期
	 */
	EXPIRED("EXPIRED"),

	/**
	 * token无效
	 */
	ERROR("ERROR"),

	/**
	 * token数据错误
	 */
	INVALID("INVALID"),

	/**
	 * token正确
	 */
	VALID("VALID");

	private String state;

	private TokenState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return this.state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}