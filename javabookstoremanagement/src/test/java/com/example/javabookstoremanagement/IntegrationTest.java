package com.example.javabookstoremanagement;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class IntegrationTest {
    @Container
    protected static final MySQLContainer MY_SQL_CONTAINER = new MySQLContainer()
            .withDatabaseName("dbtest")
            .withUsername("user")
            .withPassword("password");

    @BeforeAll
    public static void initDatabaseProperties() {
        System.setProperty("spring.datasource.url", MY_SQL_CONTAINER.getJdbcUrl());
        System.setProperty("spring.datasource.username", MY_SQL_CONTAINER.getUsername());
        System.setProperty("spring.datasource.password", MY_SQL_CONTAINER.getPassword());
    }

    public static String asString(Resource resource) {
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static String readFileToString(String path) {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource(path);
        return asString(resource);
    }
}
