package com.in28minutes.springboot.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory
            .getLogger(UserCommandLineRunner.class);

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) {
        // save a couple of customers
        repository.save(new UserJpa("Ranga", "Admin"));
        repository.save(new UserJpa("Ravi", "User"));
        repository.save(new UserJpa("Satish", "Admin"));
        repository.save(new UserJpa("Raghu", "User"));

        log.info("-------------------------------");
        log.info("Finding all users");
        log.info("-------------------------------");
        for (UserJpa user : repository.findAll()) {
            log.info(user.toString());
        }

    }

}