package com.walace.fintrack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Controller = "Router" do Spring (recebe requisições HTTP)
@RestController
public class HealthController {

    // GET /health
    @GetMapping("/health")
    public String health() {
        return "Fintrack (Spring) está online ✅";
    }
}
