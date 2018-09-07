package com.thd.pairprogram.dao;

import com.thd.pairprogram.dto.PivotalCredential;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PivotalCredentialRepository extends MongoRepository<PivotalCredential, String> {

}
