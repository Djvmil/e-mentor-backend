package org.djvmil.em.backend.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private Long responseID;
    private UserDto userDto;
    private InterviewDto interviewDto;
    private QuestionDto questionDto;
    private String responseText;
    private Long score;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

}