package org.djvmil.em.backend.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID = (Long) 1L;
    private String firstname;
    private String lastname;
    private String genre;
    private String country;

    @Column(unique = true)
    private String phoneNumber;

    @Column(unique = true)
    private String email;

    private String password;
    @Column(name = "BIRTHDATE")
    private String birthDate;

    private Boolean isEmailVerified;
    private Boolean isPhoneNumbeVerified;
    private Boolean enabled;

    @Column(unique = true)
    private String username;

    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id") ,
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<Role> roles;
    private LocalDateTime dateCreated = LocalDateTime.now();
    private LocalDateTime dateUpdated = LocalDateTime.now();

    public String formatToDB() {
        return userID.toString() + ';' +firstname + ';' + lastname + ';' + roles + ';' + genre + ';' + country + ';' + phoneNumber + ';' + email + ';' + password + ';' + birthDate + ';' + isEmailVerified + ';' + isPhoneNumbeVerified + '\n';
    }
}
