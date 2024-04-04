package org.djvmil.em.backend.core.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.djvmil.em.backend.core.entity.CommunityQuestion;
import org.djvmil.em.backend.core.entity.User;

import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor
public class CommunityResponseDto {
    private Long responseID;
    private CommunityQuestionDto questionDto;
    private UserDto userDto;

    private String responseText;
    private LocalDateTime dateCreated = LocalDateTime.now();
    private LocalDateTime dateUpdated = LocalDateTime.now();
}
