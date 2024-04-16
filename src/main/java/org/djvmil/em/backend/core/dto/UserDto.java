package org.djvmil.em.backend.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.djvmil.em.backend.core.entity.Role;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long userID = 1L;
    private String firstname;
    private String lastname;
    private String username;
    private List<Role> roles;
    private String genre;
    private String country;
    private String phoneNumber;
    private String email;
    private String birthDate;

    @JsonIgnore
    private String password;
    private Boolean isEmailVerified;
    private Boolean isPhoneNumbeVerified;

    @JsonIgnore
    private Boolean enabled;
    private Date dateCreated;
    private Date dateUpdated;

    public String formatToDB() {
        return userID.toString() + ';' +firstname + ';' + lastname + ';' + roles + ';' + password + ';' + genre + ';' + country + ';' + phoneNumber + ';' + email + ';' + birthDate + ';' + isEmailVerified + ';' + isPhoneNumbeVerified + '\n';
    }
}
