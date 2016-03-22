package com.myolnir;

import com.myolnir.model.ObjectToSave;
import com.myolnir.service.BasicMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableMongoRepositories
public class SpringBootMongoApplication implements CommandLineRunner {

    @Autowired
    private BasicMongoService basicMongoService;

    public static void main (String[] args) {
        SpringApplication.run(SpringBootMongoApplication.class);
    }

    @Override
    public void run (String... args) throws Exception {
        ObjectToSave objectToSave = new ObjectToSave();
        objectToSave.setFoo("foo");
        basicMongoService.save(objectToSave);
    }
}
