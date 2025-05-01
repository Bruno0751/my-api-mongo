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
    public Mono<Cliente> update(String id, Cliente cliente) {
        return clienteRespository.findById(id).flatMap(
                existingCliente -> {
                    existingCliente.setName(cliente.getName());
                    existingCliente.setOld_year(cliente.getOld_year());
                    existingCliente.setHeight(cliente.getHeight());
                    existingCliente.setDate_time(cliente.getDate_time());
                    return clienteRespository.save(existingCliente);
                });
    }

    @Override
    public Mono<Cliente> save(Cliente playlist) {
        return clienteRespository.save(playlist);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return clienteRespository.deleteById(id);
    }

    @Override
    public Mono<Boolean> existsById(String id) {
        return clienteRespository.existsById(id);
    }
}
