package com.ptrc.dev.wedding.invitation.responses;

import com.ptrc.dev.wedding.invitation.dtos.ConfirmationDto;

public class ResponseConfirmation {
	private String message;
	private ConfirmationDto content;

	public ResponseConfirmation() {
	}

	public ResponseConfirmation(String message, ConfirmationDto content) {
		this.message = message;
		this.content = content;
	}

	public String getMessage() {
		return message;
	}

	public ConfirmationDto getContent() {
		return content;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setContent(ConfirmationDto content) {
		this.content = content;
	}
}
