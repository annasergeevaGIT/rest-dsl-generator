package com.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SpringBootAppGenerator {

    public void generate() throws IOException {

        String basePath = "generated-project/src/main/java/generated/";
        Files.createDirectories(Path.of(basePath));

        String content = """
                package generated;

                import org.springframework.boot.SpringApplication;
                import org.springframework.boot.autoconfigure.SpringBootApplication;

                @SpringBootApplication
                public class Application {

                    public static void main(String[] args) {
                        SpringApplication.run(Application.class, args);
                    }
                }
                """;

        Files.writeString(Path.of(basePath + "Application.java"), content);
    }
}