package org.djvmil.em.backend.core.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleID;
    private String role;
    private LocalDateTime dateCreated = LocalDateTime.now();
    private LocalDateTime dateUpdated = LocalDateTime.now();

    public RoleDto(Long roleID, String role){
        this.roleID = roleID;
        this.role = role;
    }

}
