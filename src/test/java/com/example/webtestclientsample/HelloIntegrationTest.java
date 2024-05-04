package com.example.webtestclientsample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloIntegrationTest {

    @Autowired
    WebTestClient webClient;

    @Test
    void hello() {
        webClient.get().uri("/")
                .exchange()
                .expectStatus().isOk()
                .expectBody().json("""
                {"message":  "Hello"}
                """);
    }
}
