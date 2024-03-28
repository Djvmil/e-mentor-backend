package org.djvmil.em.backend.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID = (Long) 1L;

    @Column(nullable = false,length = 50)
    private String firstname;
    @Column(nullable = false, length = 50)
    private String lastname;
    @Column(name = "USER_ROLE")
    private String role;
    private String genre;
    private String country;
    private String phoneNumber;
    private String email;
    private String password;
    @Column(name = "BIRTHDATE")
    private String birthDate;

    private Boolean isEmailVerified;
    private Boolean isPhoneNumbeVerified;

    public String formatToDB() {
        return userID.toString() + ';' +firstname + ';' + lastname + ';' + role + ';' + genre + ';' + country + ';' + phoneNumber + ';' + email + ';' + password + ';' + birthDate + ';' + isEmailVerified + ';' + isPhoneNumbeVerified + '\n';
    }
}
