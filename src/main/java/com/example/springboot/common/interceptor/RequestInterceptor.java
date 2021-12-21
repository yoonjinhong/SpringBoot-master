package com.example.springboot.common.interceptor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequiredArgsConstructor
@Component
public class RequestInterceptor implements HandlerInterceptor {
	private final ObjectMapper objectMapper;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String contentType = request.getContentType();
		JsonNode requestBody = null;
		if (request.getContentType() != null && request.getContentType().contains("application/json")) {
			if (request.getInputStream() != null) {
				requestBody = objectMapper.readTree(IOUtils.toString(request.getInputStream()));
			}
		}

		log.info("\n"
						+ "[{}] - {}\n"
						+ "ContentType: {}\n"
						+ "Request Body: {}"
				, request.getMethod()
				, request.getRequestURI()
				, contentType == null ? "-" : contentType
				, requestBody == null ? "-" : objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestBody));

		return true;
	}

}
