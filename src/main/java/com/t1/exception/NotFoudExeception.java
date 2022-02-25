package com.t1.exception;

import java.util.NoSuchElementException;

public class NotFoudExeception extends NoSuchElementException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoudExeception(String message) {
		super(message);
	}

}
