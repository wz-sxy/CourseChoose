package com.askwis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
public class CourseChooseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseChooseApplication.class, args);
    }

}
