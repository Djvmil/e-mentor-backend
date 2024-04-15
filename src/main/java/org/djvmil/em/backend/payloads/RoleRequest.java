package org.djvmil.em.backend.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.djvmil.em.backend.core.entity.Role;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequest {
    String email;
    private List<String> roles;
}
