package com.developers.myapimongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.developers.myapimongo.documents.Cliente;
import com.developers.myapimongo.repositories.ClienteRespository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRespository clienteRespository;

    @Override
    public Flux<Cliente> findAll() {
        return clienteRespository.findAll();
    }

    @Override
    public Mono<Cliente> findById(String id) {
        return clienteRespository.findById(id);
    }

    @Override
    public Mono<Cliente> save(Cliente playlist) {
        return clienteRespository.save(playlist);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return clienteRespository.deleteById(id);
    }
}
