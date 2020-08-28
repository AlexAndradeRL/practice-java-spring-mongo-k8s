package com.gigaware.practice.k8s.repository;

import com.gigaware.practice.k8s.model.UuidEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UuidRepository extends ReactiveMongoRepository<UuidEntity, String> {

}
