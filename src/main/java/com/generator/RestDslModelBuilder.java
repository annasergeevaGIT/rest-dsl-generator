package com.generator;

public class RestDslModelBuilder extends com.generator.RestDslBaseListener {

    private Service service;

    public Service getService() {
        return service;
    }

    @Override
    public void enterService(com.generator.RestDslParser.ServiceContext ctx) {
        service = new Service(ctx.IDENTIFIER().getText());
    }

    @Override
    public void enterEndpoint(com.generator.RestDslParser.EndpointContext ctx) {

        String method = ctx.METHOD().getText();
        String path = ctx.path().getText();

        String request = null;
        if (ctx.request() != null) {
            request = ctx.request().IDENTIFIER().getText();
        }

        String response = ctx.IDENTIFIER().getText();

        service.addEndpoint(new Endpoint(method, path, request, response));
    }
}