package com.thd.pairprogram.controller;

import com.thd.pairprogram.dto.GenericResponse;
import com.thd.pairprogram.dto.PivotalCredential;
import com.thd.pairprogram.service.PivotalCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/pivotal")
public class PivotalCredentialController {

    @Autowired
    PivotalCredentialService pivotalCredentialService;

    @RequestMapping(value = "/add", method = POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public GenericResponse addCredential(@RequestParam(value = "id") String id, @RequestParam(value = "initial") String initial) {
        GenericResponse response = pivotalCredentialService.addCredential(id, initial);
        return response;
    }

    @RequestMapping(value = "/all", method = GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PivotalCredential> getAllCredential() {
        List<PivotalCredential> pivotalCredentials = pivotalCredentialService.getAllCredential();
        return pivotalCredentials;
    }

}
