package com.ecommerce.martialKom_microcommerce.exceptions;

import java.util.Set;

public class ObjectValidationException extends RuntimeException{

    private final Set<String> violations;

    private final String violationSource;

	public ObjectValidationException(Set<String> violations, String violationSource) {
		super();
		this.violations = violations;
		this.violationSource = violationSource;
	}

	public Set<String> getViolations() {
		return violations;
	}

	public String getViolationSource() {
		return violationSource;
	}
    
    
}
