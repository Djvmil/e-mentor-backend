package org.djvmil.em.backend.core.entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nameUser", types = {User.class})
public interface UserPrejection {
    public String getFirstname();
    public String getLastname();
    public String getEmail();
}
