package com.generator;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {

    public static void main(String[] args) throws Exception {

        CharStream input = CharStreams.fromFileName("api.dsl");

        com.generator.RestDslLexer lexer = new com.generator.RestDslLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        com.generator.RestDslParser parser = new com.generator.RestDslParser(tokens);

        ParseTree tree = parser.service();

        ParseTreeWalker walker = new ParseTreeWalker();
        RestDslModelBuilder builder = new RestDslModelBuilder();
        walker.walk(builder, tree);

        Service service = builder.getService();

        // Generate project
        MavenGenerator mavenGenerator = new MavenGenerator();
        mavenGenerator.generate();

        SpringBootAppGenerator appGenerator = new SpringBootAppGenerator();
        appGenerator.generate();

        ControllerGenerator controllerGenerator = new ControllerGenerator();
        controllerGenerator.generate(service);

        DtoGenerator dtoGenerator = new DtoGenerator();
        for (Endpoint e : service.getEndpoints()) {
            dtoGenerator.generate(e.getRequest());
            dtoGenerator.generate(e.getResponse());
        }

        System.out.println("Spring Boot project generated successfully.");
    }
}