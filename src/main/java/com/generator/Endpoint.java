package com.generator;

public class Endpoint {
    private final String method;
    private final String path;
    private final String response;

    public Endpoint(String method, String path, String response) {
        this.method = method;
        this.path = path;
        this.response = response;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getResponse() {
        return response;
    }
}
