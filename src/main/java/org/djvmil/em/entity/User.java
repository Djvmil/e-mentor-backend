package org.djvmil.em.entity;

public class User {
    private String firstname;
    private String lastname;
    private String role;
    private String genre;
    private String country;
    private String phoneNumber;
    private String email;
    private String passwors;
    private String birthDate;

    public User() {
    }

    public User(String firstname, String lastname, String role, String genre, String country, String phoneNumber, String email, String passwors, String birthDate) {
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
        return firstname + ';' + lastname + ';' + role + ';' + genre + ';' + country + ';' + phoneNumber + ';' + email + ';' + passwors + ';' + birthDate + '\n';
    }
}
