package com.example.springboot.common.response.error;

import lombok.Getter;

@Getter
public enum ErrorCode {
	/**
	 * CODE
	 * 400: 문법상 오류
	 * 403: 인증/인가 오류
	 * 404: Not Found 오류
	 * 405: 요청 메서드 오류
	 * 408: timeout
	 * 500: 서버 오류
	 */
	// Common
	BAD_REQUEST(400, "E001", "Bad Request"),

	INVALID_INPUT_VALUE(400, "E101", "Invalid Input Value"),
	INVALID_TYPE_VALUE(400, "E102", "Invalid Type Value"),
	METHOD_NOT_ALLOWED(405, "E103", "Invalid Method"),
	INVALID_VALID_ANNOTATION(400, "E104", "Invalid Valid Annotation"),

	ENTITY_NOT_FOUND(400, "E201", "Entity Not Found"),
	NOT_FOUND(404, "E202", "Not Found"),

	MISSING_REQUEST_PARAM(400, "E301", "Missing Request Param"),
	MISSING_JSON_DATA(400, "E302", "JSON Parsing Error"),

	INTERNAL_SERVER_ERROR(500, "E999", "Server Error")
	;

	private final int status;
	private final String code;
	private final String message;

	ErrorCode(int status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}
}
