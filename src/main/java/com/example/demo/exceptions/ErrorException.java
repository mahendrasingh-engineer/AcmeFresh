package com.example.demo.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorException {
	public ErrorException(LocalDateTime now, String message2, String description) {
		// TODO Auto-generated constructor stub
		timestamp=now;
		message=message2;
		details=description;
	}
	public LocalDateTime timestamp; 
	public String message;
	public String details;

}
