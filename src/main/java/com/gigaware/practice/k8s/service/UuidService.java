package com.gigaware.practice.k8s.service;

import com.gigaware.practice.k8s.UuidProvider;
import com.gigaware.practice.k8s.model.UuidEntity;
import com.gigaware.practice.k8s.repository.UuidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UuidService {

    @Autowired
    private UuidRepository uuidRepository;

    @Autowired
    private UuidProvider uuidProvider;

    public Mono<UuidEntity> findById( String id ) {
        return uuidRepository.findById( id );
    }

    public Flux<UuidEntity> findAll() {
        return uuidRepository.findAll();
    }

    public Mono<UuidEntity> create() {
        return uuidRepository.save( new UuidEntity( uuidProvider.newUuid() ) );
    }

}
