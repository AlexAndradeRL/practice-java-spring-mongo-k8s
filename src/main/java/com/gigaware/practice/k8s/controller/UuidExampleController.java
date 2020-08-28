package com.gigaware.practice.k8s.controller;

import com.gigaware.practice.k8s.model.UuidEntity;
import com.gigaware.practice.k8s.service.UuidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/uuids")
public class UuidExampleController {

    private static final Logger log = LoggerFactory.getLogger( UuidExampleController.class );

    @Autowired
    private UuidService uuidService;

    @GetMapping("/{id}")
    public Mono<UuidEntity> findById( @PathVariable String id ) {
        log.debug( "findById( {} )", id );
        return uuidService.findById( id );
    }

    @GetMapping
    public Flux<UuidEntity> findAll() {
        log.debug( "findAll()" );
        return uuidService.findAll();
    }

    @PostMapping
    public Mono<UuidEntity> create() {
        log.debug( "create()" );
        return uuidService.create();
    }

}
