package com.ecommerce.martialKom_microcommerce.validators;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Component;

import com.ecommerce.martialKom_microcommerce.exceptions.ObjectValidationException;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ObjectValidators<T> {

	  private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	  private final Validator validator = factory.getValidator();

	  public void validate(T objectToValidate) {
	    Set<ConstraintViolation<T>> violations = validator.validate(objectToValidate);
	    if (!violations.isEmpty()) {
	      Set<String> errorMessages = violations.stream()
	          .map(ConstraintViolation::getMessage)
	          .collect(Collectors.toSet());
	      throw new ObjectValidationException(errorMessages, objectToValidate.getClass().getName());
	    }
	  }
}
