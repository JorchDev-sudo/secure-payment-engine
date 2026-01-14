package com.JorchDev_sudo.payment_engine.dto;

public record AuthRequest(
        String clientId,
        String clientSecret
) {}
