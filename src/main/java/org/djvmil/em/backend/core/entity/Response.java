package org.djvmil.em.backend.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "responses")
@Data @NoArgsConstructor @AllArgsConstructor
@NamedEntityGraph(name = "response.join.tables",
        attributeNodes = {
        @NamedAttributeNode("user"),
        @NamedAttributeNode("interview"),
        @NamedAttributeNode("question")})
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long responseID;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL, optional = false)
    @JoinColumn(name = "userID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL, optional = false)
    @JoinColumn(name = "interviewID")
    private Interview interview;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL, optional = false)
    @JoinColumn(name = "questionID")
    private Question question;

    private String responseText;
    private Long score;
    private LocalDateTime dateCreated = LocalDateTime.now();
    private LocalDateTime dateUpdated = LocalDateTime.now();

}