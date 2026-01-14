package com.JorchDev_sudo.payment_engine.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue
    private UUID id;

    private BigDecimal amount;
    private String status;
    private String reference;
    private LocalDateTime createdAt;

    @ManyToOne
    private User user;

    public Transaction() {}

}

