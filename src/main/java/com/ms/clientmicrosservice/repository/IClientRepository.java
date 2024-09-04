package com.ms.clientmicrosservice.repository;

import com.ms.clientmicrosservice.model.ClientModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IClientRepository extends MongoRepository<ClientModel, String> {

    ClientModel findByClientExternalID(UUID clientExternalID);
    Boolean existsByClientExternalID(UUID clientExternalID);
}
