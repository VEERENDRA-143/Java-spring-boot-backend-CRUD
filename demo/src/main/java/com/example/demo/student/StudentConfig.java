package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){


        return args->{
            Student ram = new Student(
				1L,
				"Ram",
				"veerendra@gmail.com",
				LocalDate.of(2002,Month.MAY,9)
			);

            Student beem = new Student(
				2L,
				"Ram",
				"veerendra@gmail.com",
				LocalDate.of(2002,Month.MAY,9)
			);
            repository.saveAll(
                List.of(ram,beem)
            );
        };

    }
}
