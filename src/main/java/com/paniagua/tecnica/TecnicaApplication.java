package com.paniagua.tecnica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TecnicaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TecnicaApplication.class, args);
    }
}