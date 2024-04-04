package org.djvmil.em.backend.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor
public class BlogDto {
    private Long blogID;
    private UserDto userDto;
    private String title;
    private String content;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

}
