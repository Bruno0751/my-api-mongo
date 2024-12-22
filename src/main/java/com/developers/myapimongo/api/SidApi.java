package com.developers.myapimongo.api;

import com.developers.myapimongo.documents.Sid;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import reactor.core.publisher.Mono;

@Api(tags = {"Sid"})
@RequestMapping("/v1/sid")
public interface SidApi {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/")
    Mono<Sid> insert(@RequestBody Sid sid);

}
