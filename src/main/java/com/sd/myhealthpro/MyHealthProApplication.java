package com.sd.myhealthpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class MyHealthProApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyHealthProApplication.class, args);
    }

}
