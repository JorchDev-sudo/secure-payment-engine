package com.JorchDev_sudo.payment_engine.services;

import com.JorchDev_sudo.payment_engine.entities.Transaction;
import com.JorchDev_sudo.payment_engine.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    private final TransactionRepository repo;
    private final FraudService fraudService;

    public PaymentService(TransactionRepository repo,
                          FraudService fraudService) {
        this.repo = repo;
        this.fraudService = fraudService;
    }

    public Transaction process(Transaction tx) {

        if (fraudService.isFraud(tx.getUser())) {
            tx.setStatus("REJECTED");
        } else {
            tx.setStatus("APPROVED");
        }

        tx.setCreatedAt(LocalDateTime.now());

        return repo.save(tx);
    }
}
