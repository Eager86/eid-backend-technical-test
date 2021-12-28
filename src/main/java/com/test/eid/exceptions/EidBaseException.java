package com.test.eid.exceptions;

public class EidBaseException extends Exception {

	private static final long serialVersionUID = -7745281273767602856L;

	public EidBaseException() {
		super();
	}

	public EidBaseException(String msg, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(msg, cause, enableSuppression, writableStackTrace);
	}

	public EidBaseException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EidBaseException(String msg) {
		super(msg);
	}

	public EidBaseException(Throwable cause) {
		super(cause);
	}
}
