package org.djvmil.em.backend.exceptions;

import jakarta.validation.ConstraintViolationException;
import org.djvmil.em.backend.payloads.APIResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.springframework.web.util.WebUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
	APIResponse<String> errorResponse;

	/** Provides handling for exceptions throughout this service. */
	@ExceptionHandler({AccessDeniedException.class, NoResourceFoundException.class, UserNotFoundException.class,
			MethodArgumentNotValidException.class, ConstraintViolationException.class, AuthenticationException.class,
			BadCredentialsException.class, IllegalArgumentException.class, UserRegistrationException.class})
	public final ResponseEntity<APIResponse<String>> handleException(Exception ex, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();

		if (ex instanceof UserNotFoundException unfe) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
            return handleCustomException(unfe, headers, status, request);

		} else if (ex instanceof NoResourceFoundException exception) {
			HttpStatus status = HttpStatus.NOT_FOUND;
            return handleCustomException(exception, headers, status, request);

		} else if (ex instanceof IllegalArgumentException exception) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
            return handleCustomException(exception, headers, status, request);

		} else if (ex instanceof UserRegistrationException exception) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
            return handleCustomException(exception, headers, status, request);

		} else if (ex instanceof BadCredentialsException exception) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
            return handleCustomException(exception, headers, status, request);

		} else if (ex instanceof AccessDeniedException exception) {
			HttpStatus status = HttpStatus.FORBIDDEN;
            return handleCustomException(exception, headers, status, request);

		}else {
			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
			return handleExceptionInternal(ex, null, headers, status, request);

		}
	}

	/** Customize the response for UserNotFoundException. */
	protected ResponseEntity<APIResponse<String>> handleCustomException(Exception ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		errorResponse = new APIResponse<>(
                status.value(),
                status.name(),
                ex.getMessage(),
                getStackTrace(ex),
                request.toString()
        );

		return handleExceptionInternal(ex, errorResponse , headers, status, request);
	}

	private static String getStackTrace(Exception ex) {
		// converting the stack trace to String
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		ex.printStackTrace(printWriter);
        return stringWriter.toString();
	}

	public ResponseEntity<Map<String, String>> myMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		Map<String, String> res = new HashMap<>();

		e.getBindingResult().getAllErrors().forEach(err -> {
			String fieldName = ((FieldError) err).getField();
			String message = err.getDefaultMessage();

			res.put(fieldName, message);
		});

		return new ResponseEntity<Map<String, String>>(res, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Map<String, String>> myConstraintsVoilationException(ConstraintViolationException e) {
		Map<String, String> res = new HashMap<>();

		e.getConstraintViolations().forEach(voilation -> {
			String fieldName = voilation.getPropertyPath().toString();
			String message = voilation.getMessage();

			res.put(fieldName, message);
		});

		return new ResponseEntity<Map<String, String>>(res, HttpStatus.BAD_REQUEST);
	}
	
	//@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<String> myAuthenticationException(AuthenticationException e) {

		String res = e.getMessage();
		
		return new ResponseEntity<String>(res, HttpStatus.BAD_REQUEST);
	}


	/** A single place to customize the response body of all Exception types. */
	protected ResponseEntity<APIResponse<String>> handleExceptionInternal(Exception ex, APIResponse<String> body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
			request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
		}

		return new ResponseEntity<>(body, headers, status);
	}
}
