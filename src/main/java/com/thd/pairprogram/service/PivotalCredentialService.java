package com.thd.pairprogram.service;

import com.thd.pairprogram.dao.PivotalCredentialRepository;
import com.thd.pairprogram.dto.GenericResponse;
import com.thd.pairprogram.dto.PivotalCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PivotalCredentialService {

    @Autowired
    PivotalCredentialRepository pivotalCredentialRepository;

    @Transactional
    public GenericResponse addCredential(String id, String initial) {
        GenericResponse response = new GenericResponse();
        try {
            pivotalCredentialRepository.save(new PivotalCredential(id, initial));
            response.setStatus(HttpStatus.OK.value());
            response.setBody("User added successfully");
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setError(e.getMessage());
        }
        return response;
    }

    public List<PivotalCredential> getAllCredential() {
        List<PivotalCredential> pivotalCredentials = new ArrayList<>();
        for (PivotalCredential pivotalCredential : pivotalCredentialRepository.findAll()) {
            pivotalCredentials.add(pivotalCredential);
        }
        return pivotalCredentials;
    }

}
