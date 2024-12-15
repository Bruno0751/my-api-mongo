package com.developers.myapimongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.developers.myapimongo.documents.Cliente;
import com.developers.myapimongo.services.ClienteService;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import reactor.core.publisher.Mono;

//@Component
public class ClienteHandler {

    @Autowired
    ClienteService service;

    public Mono<ServerResponse> findAll(ServerRequest request){
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), Cliente.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request){
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findById(id), Cliente.class);
    }

    public Mono<ServerResponse> save(ServerRequest request){
        final Mono<Cliente> playlist = request.bodyToMono(Cliente.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(playlist.flatMap(service::save), Cliente.class));
    }
}
