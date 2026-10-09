package com.GlobalException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Global {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handler(Exception ex)
	{
		Map<String, Object> map=new HashMap<>();
		map.put("timestamp", LocalDateTime.now());
		map.put("status",HttpStatus.BAD_REQUEST);
		map.put("error", ex.getMessage());
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);

//		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler( NullPointerException.class)
	public ResponseEntity<?> notfound(NullPointerException ex)
	{
		Map<String, Object> map=new HashMap<>();
		map.put("timestamp", LocalDateTime.now());
		map.put("status",HttpStatus.NOT_FOUND);
		map.put("error", ex.getMessage());
		return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);

//		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler( {NullPointerException.class,
//		ArithmeticException.class})
//	public ResponseEntity<?> Allexceptionhandle(Exception ex)
//	{
//		HttpStatus status;
//		if(ex instanceof NullPointerException)
//		{
//			status=HttpStatus.NOT_FOUND;
//		}
//		else
//		{
//			status=HttpStatus.BAD_REQUEST;
//		}
//		
//		Map<String, Object> map=new HashMap<>();
//		map.put("timestamp", LocalDateTime.now());
//		map.put("status",status);
//		map.put("error","error occured");
//		return new ResponseEntity<>(map,status);
//
////		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
//	}


}
