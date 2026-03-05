package com.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MavenGenerator {

    public void generate() throws IOException {

        String pom = """
                <project xmlns="http://maven.apache.org/POM/4.0.0"
                         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                         http://maven.apache.org/xsd/maven-4.0.0.xsd">
                
                  <modelVersion>4.0.0</modelVersion>
                
                  <groupId>generated</groupId>
                  <artifactId>demo</artifactId>
                  <version>1.0</version>
                  <packaging>jar</packaging>
                
                  <parent>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-parent</artifactId>
                    <version>3.2.5</version>
                    <relativePath/>   <!-- VERY IMPORTANT -->
                  </parent>
                
                  <properties>
                    <java.version>21</java.version>
                  </properties>
                
                  <dependencies>
                    <dependency>
                      <groupId>org.springframework.boot</groupId>
                      <artifactId>spring-boot-starter-web</artifactId>
                    </dependency>
                  </dependencies>
                
                  <build>
                    <plugins>
                      <plugin>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-maven-plugin</artifactId>
                        <configuration>
                          <mainClass>generated.Application</mainClass>
                        </configuration>
                      </plugin>
                    </plugins>
                  </build>
                
                </project>
                """;

        Files.createDirectories(Path.of("generated-project"));
        Files.writeString(Path.of("generated-project/pom.xml"), pom);
    }
}