package com.test.eid.exceptions;

public class ComputeException extends EidApplicationBaseException {

	private static final long serialVersionUID = 3956467253583566811L;

	public ComputeException() {
		super();
	}

	public ComputeException(String msg, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(msg, cause, enableSuppression, writableStackTrace);
	}

	public ComputeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ComputeException(String msg) {
		super(msg);
	}

	public ComputeException(Throwable cause) {
		super(cause);
	}
}