package com.example.inicial1;

import com.example.inicial1.services.PersonaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonaAplication implements CommandLineRunner {

    @Autowired
    private PersonaServices personaService;

    public static void main(String[] args) {
        SpringApplication.run(PersonaAplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        personaService.saveInitialData();
    }
}


