package org.djvmil.em.backend.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor
public class CommunityMembershipDto {
    private Long id;
    private UserDto userDto;
    private CommunityDto communityDto;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

}
