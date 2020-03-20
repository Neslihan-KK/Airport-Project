package nes.project.airport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "nes.project.airport.repositories")
@SpringBootApplication
public class AirportApplication{

    public static void main(String[] args) {
        SpringApplication.run(AirportApplication.class, args);
    }

}