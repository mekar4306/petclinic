package com.javaegitimleri.petclinic.exception;

import org.springframework.dao.DuplicateKeyException;

public class MySQLIntegrityConstraintViolationException extends DuplicateKeyException {

	

	public MySQLIntegrityConstraintViolationException(String arg0) {
		super(arg0);
	}
}
