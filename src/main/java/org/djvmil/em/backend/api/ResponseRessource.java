package org.djvmil.em.backend.api;

import org.djvmil.em.backend.core.entity.Response;
import org.djvmil.em.backend.core.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/responses")
public class ResponseRessource {

    @Autowired
    private ResponseService service;

    @GetMapping
    public Iterable<Response> list(){

        return service.list();
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long responseId){

        return service.findById(responseId);
    }
}
