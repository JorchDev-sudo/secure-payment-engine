package com.JorchDev_sudo.payment_engine.repositories;

import com.JorchDev_sudo.payment_engine.entities.ApiClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ApiClientRepository
        extends JpaRepository<ApiClient, UUID> {

    Optional<ApiClient> findByClientId(String clientId);
}
