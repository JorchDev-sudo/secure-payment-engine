package com.JorchDev_sudo.payment_engine.services;

import com.JorchDev_sudo.payment_engine.entities.User;
import com.JorchDev_sudo.payment_engine.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudService {

    private final TransactionRepository repo;

    public FraudService(TransactionRepository repo) {
        this.repo = repo;
    }

    public boolean isFraud(User user) {

        LocalDateTime oneMinuteAgo =
                LocalDateTime.now().minusMinutes(1);

        int txCount = repo.countRecent(user, oneMinuteAgo);

        return txCount > 5;
    }
}
