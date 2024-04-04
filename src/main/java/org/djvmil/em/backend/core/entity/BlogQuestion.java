package org.djvmil.em.backend.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "blogQuestions")
@Data @NoArgsConstructor @AllArgsConstructor
public class BlogQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionID;

    @ManyToOne
    @JoinColumn(name = "blogID")
    private Blog blog;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    private String questionText;
    private LocalDateTime dateCreated = LocalDateTime.now();
    private LocalDateTime dateUpdated = LocalDateTime.now();
}
