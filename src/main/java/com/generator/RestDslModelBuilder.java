package com.generator;

public class RestDslModelBuilder extends com.generator.RestDslBaseListener {

    private Service service;

    public Service getService() {
        return service;
    }

    @Override
    public void enterService(com.generator.RestDslParser.ServiceContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        service = new Service(name);
    }

    @Override
    public void enterEndpoint(com.generator.RestDslParser.EndpointContext ctx) {

        String method = ctx.METHOD().getText();
        String path = "/" + ctx.path().IDENTIFIER().getText();
        String response = ctx.IDENTIFIER().getText();

        Endpoint endpoint = new Endpoint(method, path, response);

        service.addEndpoint(endpoint);
    }
}