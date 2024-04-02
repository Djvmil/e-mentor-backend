package org.djvmil.em.backend.core.entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nameResponse", types = {Response.class})
public interface ResponseProjection {
    public Question getQuestion();
    public String getResponseText();
    public Long getScore();
}