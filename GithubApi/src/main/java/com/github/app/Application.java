package com.github.app;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.PagedIterable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;
import java.util.List;


@SpringBootApplication

@ComponentScan(basePackages = "com.github")

@EntityScan(basePackages = "com.github.models")

@EnableJpaRepositories(basePackages = "com.github.repo")


@ComponentScan(basePackages = "com.github")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
