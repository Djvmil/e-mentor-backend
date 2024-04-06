package org.djvmil.em.backend.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.djvmil.em.backend.core.dto.UserDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
	private String accesToken;
	
	private UserDto user;
}