package com.developers.myapimongo.controller;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import com.developers.myapimongo.api.ClienteApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import com.developers.myapimongo.documents.Cliente;
import com.developers.myapimongo.services.ClienteService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class ClienteController implements ClienteApi {

    @Autowired
    ClienteService clienteService;

    public Mono<Cliente> insertCliente(@RequestBody Cliente cliente) {
        System.out.println("INTO insertCliente");
        cliente.setDate_time(LocalDate.now());
        return clienteService.save(cliente);
    }

    public Flux<Cliente> findClientes() {
        System.out.println("INTO findClientes");
        return clienteService.findAll();
    }

    @Override
    public Mono<Void> deleteCliente(String id) {
        return  clienteService.deleteById(id);
    }

    @Override
    public Mono<ResponseEntity<Cliente>> updateCliente(String id, Cliente cliente) {
        System.out.println("INTO updateCliente");
        clienteService.existsById(id).flatMap(exists -> {
            if (exists) {
                cliente.setDate_time(LocalDate.now());
                return clienteService.updateCliente(id, cliente)
                        .map(updatedCliente -> ResponseEntity.ok(updatedCliente));
            } else {
                return Mono.just("Cliente não existe");
            }
        }).subscribe(result -> {
            System.out.println(result);
        });
        return null;
    }

    public Mono<Cliente> findClienteOne(@PathVariable String id) {
        System.out.println("INTO findClienteOne");
        return clienteService.findById(id);
    }

    public Flux<Tuple2<Long, Cliente>> findClienteByWebflux() {
        System.out.println("---Start get cliente by WEBFLUX--- " + LocalDateTime.now());
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<Cliente> clientetFlux = clienteService.findAll();
        return Flux.zip(interval, clientetFlux);
    }

    public List<String> findClienteByMvc() throws InterruptedException {
        System.out.println("---Start get cliente by MVC--- " + LocalDateTime.now());
//        List<String> cliente = new ArrayList<>();
//        cliente.add("Java 8");
//        cliente.add("Spring Security");
//        cliente.add("Github");
//        cliente.add("Deploy de uma aplicação java no IBM Cloud");
//        cliente.add("Bean no Spring Framework");
//        TimeUnit.SECONDS.sleep(15);
//        return cliente;
        return null;
    }
}
