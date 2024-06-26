package org.djvmil.em.backend.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    private Long questionID;

    private String questionText;
    private String questionType;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

}