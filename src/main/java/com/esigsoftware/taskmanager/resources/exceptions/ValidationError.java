package com.esigsoftware.taskmanager.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationError(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	// Adicionando erro por erro à lista errors
	public void addErrors(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}

}
