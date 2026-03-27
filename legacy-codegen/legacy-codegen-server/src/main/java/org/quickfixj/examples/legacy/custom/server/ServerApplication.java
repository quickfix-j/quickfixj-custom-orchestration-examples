package org.quickfixj.examples.legacy.custom.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ServerApplication.class, args);
    }
}
