package com.developers.myapimongo.services;

import com.developers.myapimongo.documents.Cliente;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ClienteService {

    Flux<Cliente> findAll();

    Mono<Cliente> findById(String id);

    Mono<Cliente> save(Cliente pessoa);
}
