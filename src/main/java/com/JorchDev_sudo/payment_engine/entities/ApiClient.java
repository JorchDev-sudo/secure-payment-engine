package com.JorchDev_sudo.payment_engine.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
public class ApiClient {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true)
    private String clientId;

    private String clientSecret;

    private String name;

}
