package com.test.eid.exceptions;

public class EidApplicationBaseException extends EidBaseException {

	private static final long serialVersionUID = 7935299897819405419L;
	
	public EidApplicationBaseException() {
		super();
	}
	
	public EidApplicationBaseException(String msg, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(msg, cause, enableSuppression, writableStackTrace);
	}

	public EidApplicationBaseException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public EidApplicationBaseException(String msg) {
		super(msg);
	}
	
	public EidApplicationBaseException(Throwable cause) {
		super(cause);
	}

}
