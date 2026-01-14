package com.JorchDev_sudo.payment_engine.controllers;

import com.JorchDev_sudo.payment_engine.entities.Transaction;
import com.JorchDev_sudo.payment_engine.services.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public Transaction pay(@RequestBody Transaction tx) {

        System.out.println(
                "Thread: " + Thread.currentThread()
        );

        return service.process(tx);
    }
}
