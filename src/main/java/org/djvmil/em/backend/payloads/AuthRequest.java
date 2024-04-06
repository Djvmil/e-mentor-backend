package org.djvmil.em.backend.payloads;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.djvmil.em.backend.core.entity.Role;

import java.util.Date;
import java.util.List;

@Data
public class AuthRequest {
	private String firstname;
	private String lastname;
	private List<Role> roles;
	private String genre;
	private String country;
	private String phoneNumber;
	private String email;
	private String birthDate;
	private String password;
	private Boolean isEmailVerified;
	private Boolean isPhoneNumbeVerified;

	@JsonIgnore
	private Boolean enabled;
	private Date dateCreated;
	private Date dateUpdated;
}