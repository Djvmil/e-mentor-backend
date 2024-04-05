package org.djvmil.em.backend.payloads;

import lombok.Data;
import org.djvmil.em.backend.core.dto.UserDto;

@Data
public class JWTAuthResponse {
	private String token;
	
	private UserDto user;
}