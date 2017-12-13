package org.mitre.openid.connect.web;

import org.springframework.http.HttpStatus;

public class ResponseUtils {
	
	public static <T extends Object> ResponseEntity<T> renderSuccess(T object, HttpStatus status) {
		return ResponseUtils.renderSuccess(object, status, 0);
	}

	public static <T extends Object> ResponseEntity<T> renderSuccess(T object, HttpStatus status, int total) {
		ResponseEntity<T> responseEntity = new ResponseEntity<T>();
		responseEntity.setSuccess(true);
		responseEntity.setBody(object);
		responseEntity.setAuthenticated(true);
		responseEntity.setStatusCode(status);
		responseEntity.setTotal(total);
		return responseEntity;
	}

	public static <T extends Object> ResponseEntity<T> renderError(ResponseEntity<T> responseEntity, Throwable throwable) {
		responseEntity.setSuccess(false);
		if (throwable instanceof NullPointerException) {
			responseEntity.setErrorMessage("Unhandled Server Exception");
		} else {
			responseEntity.setErrorMessage(throwable.getMessage());
		}
		responseEntity.setStatusCode(HttpStatus.BAD_REQUEST);
		responseEntity.setAuthenticated(true);
		return responseEntity;
	}
	
	public static <T extends Object> ResponseEntity<T> renderCustomError(ResponseEntity<T> responseEntity, String errorMessage) {
		responseEntity.setSuccess(false);
		responseEntity.setAuthenticated(true);
		responseEntity.setErrorMessage(errorMessage);
		responseEntity.setStatusCode(HttpStatus.BAD_REQUEST);
		return responseEntity;
	}
	
	public static <T extends Object> ResponseEntity<T> renderCustomError(ResponseEntity<T> responseEntity, String errorMessage,boolean authenticated) {
		responseEntity.setSuccess(false);
		responseEntity.setAuthenticated(authenticated);
		responseEntity.setErrorMessage(errorMessage);
		responseEntity.setStatusCode(HttpStatus.BAD_REQUEST);
		return responseEntity;
	}
}
