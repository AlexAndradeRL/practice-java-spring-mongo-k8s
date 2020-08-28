package com.gigaware.practice.k8s;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidProvider {

    public String newUuid() {
        return UUID.randomUUID().toString();
    }

}
