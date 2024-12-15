package com.developers.myapimongo.repositories;

import com.developers.myapimongo.documents.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClienteRespository extends ReactiveMongoRepository<Cliente, String> {
}
