package org.djvmil.em.backend.payloads;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class APIResponse<T> {
	private int code;
	private String status;
	private String message;

	@JsonIgnore
	private String stackTrace;
	private T data;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date timestamp;

	public APIResponse(int code, String status, String message, String stackTrace, T data) {
		this.code = code;
		this.status = status;
		this.message = message;
		this.stackTrace = stackTrace;
		this.data = data;
		timestamp = new Date();
	}

	public APIResponse() {
		timestamp = new Date();
	}

    public APIResponse(HttpStatus httpStatus, String message) {
		this.code = httpStatus.value();
		this.status = httpStatus.name();
		this.message = message;
		timestamp = new Date();
    }

}
