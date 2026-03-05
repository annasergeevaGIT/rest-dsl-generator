package com.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DtoGenerator {

    public void generate(String name) throws IOException {

        if (name == null) return;

        String basePath = "generated-project/src/main/java/generated/dto/";
        Files.createDirectories(Path.of(basePath));

        String content = """
                package generated.dto;

                public class %s {

                    private String id;

                    public String getId() { return id; }

                    public void setId(String id) { this.id = id; }
                }
                """.formatted(name);

        Files.writeString(Path.of(basePath + name + ".java"), content);
    }
}