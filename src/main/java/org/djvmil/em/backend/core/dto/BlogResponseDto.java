package org.djvmil.em.backend.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor
public class BlogResponseDto {
    private Long responseID;
    private BlogQuestionDto blogQuestionDto;
    private UserDto userDto;

    private String responseText;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
}
