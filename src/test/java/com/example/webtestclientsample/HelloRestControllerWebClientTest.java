package com.example.webtestclientsample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
public class HelloRestControllerWebClientTest {

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
