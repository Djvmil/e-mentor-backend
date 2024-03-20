package org.djvmil.em.backend.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserForm {
    private Long id = 1L;

    @NotBlank(message = "Firstname required")
    private String firstname;
    @NotBlank
    private String lastname;
    private String role;
    private String genre;
    private String country;
    private String phoneNumber;
    @Size(min = 2, max = 20, message = "min 2 et max 50")
    private String email;
    private String passwors;
    private String birthDate;

    public UserForm() {
    }

    public UserForm(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public UserForm(Long id, String firstname, String lastname, String role, String genre, String country, String phoneNumber, String email, String passwors, String birthDate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.genre = genre;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passwors = passwors;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPasswors() {
        return passwors;
    }

    public void setPasswors(String passwors) {
        this.passwors = passwors;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id ='" + id + '\'' +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", role='" + role + '\'' +
                ", genre='" + genre + '\'' +
                ", country='" + country + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", passwors='" + passwors + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

    public String formatToDB() {
        return id.toString() + ';' +firstname + ';' + lastname + ';' + role + ';' + genre + ';' + country + ';' + phoneNumber + ';' + email + ';' + passwors + ';' + birthDate + '\n';
    }
}
