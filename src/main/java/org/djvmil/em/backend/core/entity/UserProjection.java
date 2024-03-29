package org.djvmil.em.backend.core.entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nameUser", types = {User.class})
public interface UserProjection {
    public String getFirstname();
    public String getLastname();
    public String getEmail();
}
