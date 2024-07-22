package com.developers.myapimongo.repositories;

import com.developers.myapimongo.documents.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRespositoryDelete extends MongoRepository<Cliente, String> {
}
