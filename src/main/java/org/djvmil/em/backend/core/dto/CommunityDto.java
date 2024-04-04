package org.djvmil.em.backend.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor
public class CommunityDto {

    private Long communityID;
    private String name;
    private String description;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
}