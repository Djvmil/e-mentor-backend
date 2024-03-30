package org.djvmil.em.backend.core.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long userID = 1L;
    private String firstname;
    private String lastname;
    private String role;
    private String genre;
    private String country;
    private String phoneNumber;
    private String email;
    private String birthDate;
    private Boolean isEmailVerified;
    private Boolean isPhoneNumbeVerified;

    public String formatToDB() {
        return userID.toString() + ';' +firstname + ';' + lastname + ';' + role + ';' + genre + ';' + country + ';' + phoneNumber + ';' + email + ';' + birthDate + ';' + isEmailVerified + ';' + isPhoneNumbeVerified + '\n';
    }
}
