package com.generator;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private final String name;
    private final List<Endpoint> endpoints = new ArrayList<>();

    public Service(String name) {
        this.name = name;
    }

    public void addEndpoint(Endpoint endpoint) {
        endpoints.add(endpoint);
    }

    public String getName() {
        return name;
    }

    public List<Endpoint> getEndpoints() {
        return endpoints;
    }
}
