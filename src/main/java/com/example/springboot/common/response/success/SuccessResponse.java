package com.example.springboot.common.response.success;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SuccessResponse<T> {
	private int status;
	private String code;
	private String message;
	private T payload;

	public SuccessResponse(HttpStatus status) {
		this.status = status.value();
		this.message = status.getReasonPhrase();
		this.payload = null;
	}

	public SuccessResponse(SuccessCode successCode) {
		this.status = successCode.getStatus();
		this.code = successCode.getCode();
		this.message = successCode.getMessage();
		this.payload = null;
	}

	public SuccessResponse(HttpStatus status, T payload) {
		this.status = status.value();
		this.message = status.getReasonPhrase();
		this.payload = payload;
	}

	public SuccessResponse(SuccessCode successCode, T payload) {
		this.status = successCode.getStatus();
		this.code = successCode.getCode();
		this.message = successCode.getMessage();
		this.payload = payload;
	}
}
