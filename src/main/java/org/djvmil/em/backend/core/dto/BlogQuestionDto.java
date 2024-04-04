package org.djvmil.em.backend.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor
public class BlogQuestionDto {
    private Long questionID;

    private BlogDto blogDto;
    private UserDto userDto;
    private String questionText;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
}
