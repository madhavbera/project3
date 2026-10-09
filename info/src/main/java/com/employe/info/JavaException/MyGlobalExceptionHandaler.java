package com.employe.info.JavaException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class MyGlobalExceptionHandaler {
@ExceptionHandler(ExceptionHandeler.class)
@ResponseBody
public ResponseEntity<?> handle(ExceptionHandeler ex)
{
	Map<String, Object> body = new HashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message", ex.getMessage());
    body.put("status", HttpStatus.NOT_FOUND.value());

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
@ExceptionHandler(ArithmeticException.class)
public ResponseEntity<?> Handle(ArithmeticException ax)
{
	Map<String, Object> map=new HashMap<>();
	map.put("timestamp", LocalDateTime.now());
	map.put("status",HttpStatus.BAD_REQUEST);
	map.put("error", ax.getMessage());
	return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
}
//@ExceptionHandler(ExceptionHandeler.class)
//public ResponseEntity<Exception> handler(ExceptionHandler ex)
//{
//	Exception e=new Exception(
//			500,"Internal Server Error",
//			((Throwable) ex).getMessage());
//	return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
//	}

}
