package com.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ControllerGenerator {

    public void generate(Service service) throws IOException {

        String basePath = "generated-project/src/main/java/generated/";
        Files.createDirectories(Path.of(basePath));

        String className = service.getName() + "Controller";

        StringBuilder sb = new StringBuilder();

        sb.append("package generated;\n\n");
        sb.append("import org.springframework.web.bind.annotation.*;\n");
        sb.append("import generated.dto.*;\n\n");

        sb.append("@RestController\n");
        sb.append("public class ").append(className).append(" {\n\n");

        for (Endpoint e : service.getEndpoints()) {

            String methodName = buildMethodName(e);

            sb.append("    ").append(getMapping(e.getMethod()))
                    .append("(\"").append(e.getPath()).append("\")\n");

            sb.append("    public ").append(e.getResponse())
                    .append(" ").append(methodName).append("(");

            boolean first = true;

            // Path variable
            if (e.getPath().contains("{")) {
                String var = e.getPath()
                        .substring(e.getPath().indexOf("{")+1, e.getPath().indexOf("}"));

                sb.append("@PathVariable String ").append(var);
                first = false;
            }

            // Request body
            if (e.getRequest() != null) {
                if (!first) sb.append(", ");
                sb.append("@RequestBody ").append(e.getRequest()).append(" request");
            }

            sb.append(") {\n");
            sb.append("        return new ").append(e.getResponse()).append("();\n");
            sb.append("    }\n\n");
        }

        sb.append("}\n");

        Files.writeString(Path.of(basePath + className + ".java"), sb.toString());
    }

    private String getMapping(String method) {
        return switch (method) {
            case "GET" -> "@GetMapping";
            case "POST" -> "@PostMapping";
            case "PUT" -> "@PutMapping";
            case "DELETE" -> "@DeleteMapping";
            default -> "@RequestMapping";
        };
    }

    private String buildMethodName(Endpoint e) {

        String path = e.getPath()
                .replace("/", "_")
                .replace("{", "")
                .replace("}", "");

        return e.getMethod().toLowerCase() + path;
    }
}