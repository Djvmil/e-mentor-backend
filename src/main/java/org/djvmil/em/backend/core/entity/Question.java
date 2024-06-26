package org.djvmil.em.backend.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "questions")
@Data @NoArgsConstructor @AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionID;
    private String questionText;
    private String questionType;
    private LocalDateTime dateCreated = LocalDateTime.now();
    private LocalDateTime dateUpdated = LocalDateTime.now();

}