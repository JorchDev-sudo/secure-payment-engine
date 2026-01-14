package com.JorchDev_sudo.payment_engine.config;

import com.JorchDev_sudo.payment_engine.entities.ApiClient;
import com.JorchDev_sudo.payment_engine.repositories.ApiClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner loadData(ApiClientRepository repository) {

        return args -> {

            if (repository.findByClientId("order-service").isEmpty()) {

                ApiClient client = new ApiClient();
                client.setClientId("order-service");
                client.setClientSecret("secret123");
                client.setName("Order Microservice");

                repository.save(client);

                System.out.println("✅ API Client working");
            }
        };
    }
}
