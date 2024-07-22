package com.developers.myapimongo.api;

import com.developers.myapimongo.documents.Cliente;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.util.List;

@Api(tags = {"Cliente"})
@RequestMapping("/v1/cliente")
public interface ClienteApi {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/insert")
    Mono<Cliente> insertCliente(@RequestBody Cliente cliente);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/find")
    Flux<Cliente> findCliente();

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(value = "/delete/{id}")
    Mono<Void> deleteCliente(@PathVariable String id);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/findOne/{id}")
    Mono<Cliente> findClienteOne(@PathVariable String id);

    @GetMapping(value="/cliente/webflux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Tuple2<Long, Cliente>> findClienteByWebflux();

    @GetMapping(value="/cliente/mvc")
    List<String> findClienteByMvc() throws InterruptedException;
}
