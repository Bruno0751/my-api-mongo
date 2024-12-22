package com.developers.myapimongo.controller;

import com.developers.myapimongo.api.SidApi;
import com.developers.myapimongo.documents.Sid;
import com.developers.myapimongo.services.SidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RestController
public class SidController implements SidApi {

    @Autowired
    SidService sidService;

    @Override
    public Mono<Sid> insert(@RequestBody Sid sid) {
        System.out.println("INTO insert");
        sid.setDate_time(LocalDate.now());
        return sidService.save(sid);
    }
}
