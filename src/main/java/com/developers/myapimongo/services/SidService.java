package com.developers.myapimongo.services;

import com.developers.myapimongo.documents.Sid;
import reactor.core.publisher.Mono;

public interface SidService {

    Mono<Sid> save(Sid sid);

}
