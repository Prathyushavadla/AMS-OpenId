package org.mitre.openid.connect.web;

import org.springframework.http.HttpStatus;

public class ResponseEntity<T extends Object> {

	private boolean success;
	
	private boolean authenticated;

	private String errorMessage;

	private HttpStatus statusCode;

	private int total;

	private T body;

	public ResponseEntity() {
	}

	public ResponseEntity(T body, HttpStatus statusCode, boolean success, int total) {
		this.body = body;
		this.statusCode = statusCode;
		this.success = success;
		this.total = total;
	}

	public ResponseEntity(T body, HttpStatus statusCode, boolean success) {
		this.body = body;
		this.statusCode = statusCode;
		this.success = success;
	}

	public ResponseEntity(HttpStatus statusCode, boolean success, String errorMessage) {
		this.statusCode = statusCode;
		this.success = success;
		this.errorMessage = errorMessage;
	}

	public ResponseEntity(T body, HttpStatus statusCode, boolean success, String errorMessage) {
		this.body = body;
		this.statusCode = statusCode;
		this.success = success;
		this.errorMessage = errorMessage;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
