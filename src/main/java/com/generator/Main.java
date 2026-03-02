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

        System.out.println("Service: " + service.getName());

        for (Endpoint e : service.getEndpoints()) {
            System.out.println(e.getMethod() + " " + e.getPath());
        }
    }
}