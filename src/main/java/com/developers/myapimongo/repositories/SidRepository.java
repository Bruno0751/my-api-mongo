package com.developers.myapimongo.repositories;

import com.developers.myapimongo.documents.Sid;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SidRepository extends ReactiveMongoRepository<Sid, String> {
}
