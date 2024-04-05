package com.ecommerce.martialKom_microcommerce.handlers;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExceptionRepresentation {

    private String errorMessage;
    private String errorSource;
    private Set<String> validationErrors;
	public ExceptionRepresentation(String errorMessage, String errorSource, Set<String> validationErrors) {
		super();
		this.errorMessage = errorMessage;
		this.errorSource = errorSource;
		this.validationErrors = validationErrors;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorSource() {
		return errorSource;
	}
	public void setErrorSource(String errorSource) {
		this.errorSource = errorSource;
	}
	public Set<String> getValidationErrors() {
		return validationErrors;
	}
	public void setValidationErrors(Set<String> validationErrors) {
		this.validationErrors = validationErrors;
	}
	public ExceptionRepresentation() {
		super();
	}
    
    

}