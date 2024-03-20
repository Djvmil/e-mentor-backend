package org.djvmil.em.backend.form;

import java.time.LocalDateTime;

public class InterviewForm {
    private Long interviewID;

    private String title;
    private String description;
    private String requiredSkills;
    private String company;
    private LocalDateTime dateTime;


    //Question
    private Long questionID;

    private String questionText;
    private String questionType;

    //Response
    private Long responseID;
    private String responseText;
    private Long score;


    //User
    private Long userId = 1L;

    private String firstname;
    private String lastname;
    private String role;
    private String genre;
    private String country;
    private String phoneNumber;
    private String email;
    private String password;
    private String birthDate;

    public InterviewForm() {
    }

    public InterviewForm(Long interviewID, String title, String description, String requiredSkills, String company, LocalDateTime dateTime, Long questionID, String questionText, String questionType, Long responseID, String responseText, Long score, Long userId, String firstname, String lastname, String role, String genre, String country, String phoneNumber, String email, String password, String birthDate) {
        this.interviewID = interviewID;
        this.title = title;
        this.description = description;
        this.requiredSkills = requiredSkills;
        this.company = company;
        this.dateTime = dateTime;
        this.questionID = questionID;
        this.questionText = questionText;
        this.questionType = questionType;
        this.responseID = responseID;
        this.responseText = responseText;
        this.score = score;
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.genre = genre;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
    }

    public Long getInterviewID() {
        return interviewID;
    }

    public void setInterviewID(Long interviewID) {
        this.interviewID = interviewID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public Long getResponseID() {
        return responseID;
    }

    public void setResponseID(Long responseID) {
        this.responseID = responseID;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}
