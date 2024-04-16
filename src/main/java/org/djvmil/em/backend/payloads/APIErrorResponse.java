package org.djvmil.em.backend.payloads;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@AllArgsConstructor
public class APIErrorResponse {
	private int code;
	private String status;
	private String message;
	private String stackTrace;
	private String data;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date timestamp;

	public APIErrorResponse(int code, String status, String message, String stackTrace, String data) {
		this.code = code;
		this.status = status;
		this.message = message;
		this.stackTrace = stackTrace;
		this.data = data;
		timestamp = new Date();
	}

	public APIErrorResponse() {
		timestamp = new Date();
	}

    public APIErrorResponse(HttpStatus httpStatus, String authenticationError) {
		this.code = httpStatus.value();
		this.status = httpStatus.name();
		this.message = authenticationError;
		timestamp = new Date();
    }
}
