package com.example.webtestclientsample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloRestControllerMockMvcTest {

    @Autowired
    WebTestClient webClient;

    @Autowired
    MockMvc mvc;

    @Test
    void hello1() {
        webClient.get().uri("/")
                .exchange()
                .expectStatus().isOk()
                .expectBody().json("""
                {"message":  "Hello"}
                """);
    }

    @Test
    void hello2() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                {"message":  "Hello"}
                """));
    }
}
