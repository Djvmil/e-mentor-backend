package org.djvmil.em.backend.core.entity;


//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID = 1L;

    @Column(nullable = false,length = 50)
    private String firstname;
    @Column(nullable = false,length = 50)
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

    public User() {
    }

    public User(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public User(Long id, String firstname, String lastname, String role, String genre, String country, String phoneNumber, String email, String passwors, String birthDate) {
        this.userID = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.genre = genre;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = passwors;
        this.birthDate = birthDate;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public Boolean getPhoneNumbeVerified() {
        return isPhoneNumbeVerified;
    }

    public void setPhoneNumbeVerified(Boolean phoneNumbeVerified) {
        isPhoneNumbeVerified = phoneNumbeVerified;
    }

    @Override
    public String toString() {
        return "User{" +
                "id ='" + userID + '\'' +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", role='" + role + '\'' +
                ", genre='" + genre + '\'' +
                ", country='" + country + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", passwors='" + password + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", isEmailVerified='" + isEmailVerified + '\'' +
                ", isPhoneNumbeVerified='" + isPhoneNumbeVerified + '\'' +
                '}';
    }

    public String formatToDB() {
        return userID.toString() + ';' +firstname + ';' + lastname + ';' + role + ';' + genre + ';' + country + ';' + phoneNumber + ';' + email + ';' + password + ';' + birthDate + ';' + isEmailVerified + ';' + isPhoneNumbeVerified + '\n';
    }
}
