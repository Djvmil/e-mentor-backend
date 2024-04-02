package org.djvmil.em.backend.core.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterviewDto {

    private Long interviewID;
    private String title;
    private String description;
    private String requiredSkills;
    private String company;
    private LocalDateTime dateTime;

}