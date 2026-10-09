package com.ATM.MANAGEMENT.SYSTEM.demo.Exceptionhandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Globalhandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handle(Exception ex)
	{
		Map<String, Object> map=new HashMap<>();
		map.put("Error:",ex.getMessage());
		map.put("Time:", LocalDateTime.now());
		map.put("status:",HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(map,HttpStatus.OK);
	}

}
