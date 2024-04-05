package org.djvmil.em.backend.security.errors;


import org.springframework.http.HttpStatus;

public record ErrosResponse(
        HttpStatus httpStatus,
        String message
) {

}