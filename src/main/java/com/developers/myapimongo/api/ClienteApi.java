package com.developers.myapimongo.api;

import com.developers.myapimongo.documents.Cliente;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import java.util.List;

@Api(tags = {"Cliente"})
@RequestMapping("/v1/cliente")
public interface ClienteApi {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    Mono<Cliente> insert(@RequestBody @Valid Cliente cliente);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    Flux<Cliente> findAll();

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    Mono<Void> delete(@PathVariable String id);

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    Mono<ResponseEntity<Cliente>> update(@PathVariable String id, @RequestBody Cliente cliente);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    Mono<Cliente> findOne(@PathVariable String id);

    @GetMapping(value="/webflux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Tuple2<Long, Cliente>> findByWebFlux();

    @GetMapping(value="/mvc")
    List<String> findByMvc() throws InterruptedException;
}
