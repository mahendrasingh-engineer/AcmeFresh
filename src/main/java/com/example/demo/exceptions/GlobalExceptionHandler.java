package com.example.demo.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(AlreadyExistException.class)
	String fun1() {
		return "this phone is registereg already";
	}
	@ExceptionHandler(AlreadyExistException.class)
	String fun2() {
		return "this phone is not  registered please regiser first";
	}
	
}
