package org.djvmil.em.backend.core.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.djvmil.em.backend.core.entity.Interview;
import org.djvmil.em.backend.core.entity.Question;
import org.djvmil.em.backend.core.entity.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private Long responseID;
    private UserDto user;
    private InterviewDto interview;
    private QuestionDto question;
    private String responseText;
    private Long score;

}