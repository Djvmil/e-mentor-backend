package org.djvmil.em.backend.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "communityResponses")
@Data @NoArgsConstructor @AllArgsConstructor
public class CommunityResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long responseID;

    @ManyToOne
    @JoinColumn(name = "questionID")
    private CommunityQuestion question;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    private String responseText;
    private LocalDateTime dateCreated = LocalDateTime.now();
    private LocalDateTime dateUpdated = LocalDateTime.now();
}
