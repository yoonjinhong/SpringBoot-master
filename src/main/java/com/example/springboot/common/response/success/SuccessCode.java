package com.example.springboot.common.response.success;

import lombok.Getter;

@Getter
public enum SuccessCode {
	// Common
	OK(200, "S001", "Success"),

	CREATED(201, "S002", "Success Create"),
	MODIFIED(201, "S003", "Success Modify"),
	DELETED(201, "S004", "Success Delete")

	;

	private final int status;
	private final String code;
	private final String message;

	SuccessCode(int status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}
}
