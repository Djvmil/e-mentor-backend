package org.djvmil.em.backend.core.entity;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Interviews")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interviewID;

    private String title;
    private String description;
    private String requiredSkills;
    private String company;

    @Column(name="datetime")
    private LocalDateTime dateTime;

    public Interview() {
    }

    public Interview(Long interviewID, String title, String description, String requiredSkills, String company, LocalDateTime dateTime) {
        this.interviewID = interviewID;
        this.title = title;
        this.description = description;
        this.requiredSkills = requiredSkills;
        this.company = company;
        this.dateTime = dateTime;
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

    @Override
    public String toString() {
        return "Interview{" +
                "interviewID=" + interviewID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", requiredSkills='" + requiredSkills + '\'' +
                ", company='" + company + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}