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
    ClienteRespository playlistRespository;

    @Override
    public Flux<Cliente> findAll() {
        return playlistRespository.findAll();
    }

    @Override
    public Mono<Cliente> findById(String id) {
        return playlistRespository.findById(id);
    }

    @Override
    public Mono<Cliente> save(Cliente playlist) {
        return playlistRespository.save(playlist);
    }
}
