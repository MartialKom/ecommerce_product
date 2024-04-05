package com.ecommerce.martialKom_microcommerce.handlers;

import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.ecommerce.martialKom_microcommerce.exceptions.ObjectValidationException;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	  @ExceptionHandler({ObjectValidationException.class})
	  public ResponseEntity<ExceptionRepresentation> handleException(ObjectValidationException exception) {
	    ExceptionRepresentation representation = new ExceptionRepresentation(
	    		"Object not valid exception has occurred",
	    		exception.getViolationSource(),
	    		exception.getViolations()
	    		
	    		);
	    
	    return ResponseEntity
	        .status(HttpStatus.BAD_REQUEST)
	        .contentType(MediaType.APPLICATION_JSON)
	        .body(representation);
	  }
	  
	  @ExceptionHandler(EntityNotFoundException.class)
	  public ResponseEntity<ExceptionRepresentation> handleException(EntityNotFoundException exception) {
	    ExceptionRepresentation representation = new ExceptionRepresentation(
	    		exception.getMessage(),
	    		null,
	    		null
	    		);
	    return ResponseEntity
	        .status(HttpStatus.NOT_FOUND)
	        .body(representation);
	  }
	  
	  @ExceptionHandler(NoSuchElementException.class)
	  public ResponseEntity<ExceptionRepresentation> handleException(NoSuchElementException exception) {
	    ExceptionRepresentation representation = new ExceptionRepresentation(
	    		exception.getMessage(),
	    		null,
	    		null
	    		);
	    return ResponseEntity
	        .status(HttpStatus.NOT_FOUND)
	        .body(representation);
	  }
	  
	  @ExceptionHandler(DataIntegrityViolationException.class)
	  public ResponseEntity<ExceptionRepresentation> handleException() {
		    ExceptionRepresentation representation = new ExceptionRepresentation(
		    		"A product already exists with the provided label",
		    		null,
		    		null
		    		);
	    return ResponseEntity
	        .status(HttpStatus.BAD_REQUEST)
	        .body(representation);
	  }

}
