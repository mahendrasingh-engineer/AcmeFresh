package com.example.demo.exceptions;

public class InvalidKeyException extends RuntimeException{
	public InvalidKeyException() {
		
	}
	public InvalidKeyException(String msg) {
		super(msg);
	}
}
