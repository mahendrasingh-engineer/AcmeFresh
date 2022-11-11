package com.example.demo.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(AlreadyExistException.class)
	String fun1() {
		return "this phone is registereg already";
	}
	@ExceptionHandler(CustomerNotFound.class)
	String fun2() {
		return "this phone is not  registered please regiser first";
	}
	@ExceptionHandler(InvalidKeyException.class)
	public ResponseEntity<ErrorException> fun3(InvalidKeyException cnfe, WebRequest wq){
		
		return new ResponseEntity<ErrorException>(new ErrorException(LocalDateTime.now(),cnfe.getMessage(),
				wq.getDescription(false)), HttpStatus.BAD_REQUEST);
	}
}
