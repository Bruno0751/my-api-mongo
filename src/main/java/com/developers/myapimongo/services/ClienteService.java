package com.developers.myapimongo.services;

import com.developers.myapimongo.documents.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteService {

    Flux<Cliente> findAll();

    Mono<Cliente> findById(String id);

    Mono<Cliente> updateCliente(String id, Cliente cliente);

    Mono<Cliente> save(Cliente pessoa);

    Mono<Void> deleteById(String id);

    Mono<Boolean> existsById(String id);
}
