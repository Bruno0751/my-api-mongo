package com.developers.myapimongo.services;

import com.developers.myapimongo.documents.Sid;
import com.developers.myapimongo.repositories.SidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SisServiceImpl implements SidService {

    @Autowired
    SidRepository sidRepository;

    @Override
    public Mono<Sid> save(Sid sid) {
        return sidRepository.save(sid);
    }
}
