package org.quickfixj.examples.legacy.custom.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ClientApplication.class, args);
    }
}