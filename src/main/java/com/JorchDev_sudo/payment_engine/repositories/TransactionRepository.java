package com.JorchDev_sudo.payment_engine.repositories;

import com.JorchDev_sudo.payment_engine.entities.Transaction;
import com.JorchDev_sudo.payment_engine.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.UUID;

public interface TransactionRepository
        extends JpaRepository<Transaction, UUID> {

    @Query("""
        SELECT COUNT(t)
        FROM Transaction t
        WHERE t.user = :user
        AND t.createdAt > :since
   """)
    int countRecent(User user, LocalDateTime since);
}
