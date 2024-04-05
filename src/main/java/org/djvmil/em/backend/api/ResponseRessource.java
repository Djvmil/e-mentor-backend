package org.djvmil.em.backend.api;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.djvmil.em.backend.core.dto.ResponseDto;
import org.djvmil.em.backend.core.entity.Response;
import org.djvmil.em.backend.core.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/responses")
@CrossOrigin
@SecurityRequirement(name = "E-Mentor Application")
public class ResponseRessource {

    @Autowired
    private ResponseService service;

    @GetMapping
    public Iterable<ResponseDto> list(){

        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseDto findById(@PathVariable("id") Long responseId){

        return service.findById(responseId);
    }
}
