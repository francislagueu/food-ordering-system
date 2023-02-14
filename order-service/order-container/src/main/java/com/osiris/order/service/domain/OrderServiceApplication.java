package com.osiris.order.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created By francislagueu on 2/10/23
 */

@EnableJpaRepositories(basePackages = "com.osiris.order.service.dataaccess")
@EntityScan(basePackages = "com.osiris.order.service.dataaccess")
@SpringBootApplication(scanBasePackages = "com.osiris")
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
