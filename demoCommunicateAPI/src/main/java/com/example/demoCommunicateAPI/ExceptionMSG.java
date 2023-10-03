package com.example.demoCommunicateAPI;

public enum ExceptionMSG {
	SUCCESS("200", "成功"), FAILED("999", "失敗");

	private String code;
	private String msg;

	private ExceptionMSG(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
