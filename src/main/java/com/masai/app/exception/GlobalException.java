package com.masai.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {

		@ExceptionHandler(IllegalArgumentException.class)
		public ResponseEntity<?> illegalException(IllegalArgumentException ex){
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(NoHandlerFoundException.class)
		public ResponseEntity<?> noHandler(NoHandlerFoundException ex,WebRequest req){
			
			return new ResponseEntity<String>(ex.getDetailMessageCode(),HttpStatus.NOT_FOUND);
		}
}
