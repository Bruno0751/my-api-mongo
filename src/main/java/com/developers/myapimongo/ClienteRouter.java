package com.developers.myapimongo;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

//@Configuration
public class ClienteRouter {

//    @Bean
    public RouterFunction<ServerResponse> route(ClienteHandler handler){
        return RouterFunctions
                .route(GET("/cliente").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/cliente/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
                .andRoute(POST("/cliente").and(accept(MediaType.APPLICATION_JSON)), handler::save);

    }
}
