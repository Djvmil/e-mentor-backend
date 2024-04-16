package org.djvmil.em.backend.security.errors;

public class CustomParameterConstraintException extends RuntimeException {
    public CustomParameterConstraintException() {
        super();
    }

    public CustomParameterConstraintException(String message) {
        super(message);
    }
}