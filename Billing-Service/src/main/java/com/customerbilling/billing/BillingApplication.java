package com.customerbilling.billing;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan("com.customerbilling.billing.model")
public class BillingApplication {

    public static void main(String[] args){
        SpringApplication.run(BillingApplication.class, args);
    }

}
