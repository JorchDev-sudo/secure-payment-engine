package com.JorchDev_sudo.payment_engine.controllers;

import com.JorchDev_sudo.payment_engine.dto.AuthRequest;
import com.JorchDev_sudo.payment_engine.dto.AuthResponse;
import com.JorchDev_sudo.payment_engine.entities.ApiClient;
import com.JorchDev_sudo.payment_engine.repositories.ApiClientRepository;
import com.JorchDev_sudo.payment_engine.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final ApiClientRepository repository;
    private final JwtService jwtService;

    public AuthController(ApiClientRepository repository,
                          JwtService jwtService) {
        this.repository = repository;
        this.jwtService = jwtService;
    }

    @PostMapping("/token")
    public ResponseEntity<AuthResponse> authenticate(
            @RequestBody AuthRequest request) {

        ApiClient client = repository
                .findByClientId(request.clientId())
                .orElseThrow(() ->
                        new RuntimeException("Invalid client"));

        if (!client.getClientSecret()
                .equals(request.clientSecret())) {
            throw new RuntimeException("Invalid secret");
        }

        String token = jwtService.generateToken(client.getClientId());

        return ResponseEntity.ok(new AuthResponse(token));
    }
}
