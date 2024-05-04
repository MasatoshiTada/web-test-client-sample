package com.example.webtestclientsample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloRestController {

    @GetMapping("/")
    public Map<String, String> hello() {
        return Map.of("message","Hello");
    }
}
