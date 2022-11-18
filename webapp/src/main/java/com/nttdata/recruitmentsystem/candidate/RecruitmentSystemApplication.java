package com.nttdata.recruitmentsystem.candidate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.nttdata")
@EnableJpaRepositories(basePackages = "com.nttdata")
public class RecruitmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruitmentSystemApplication.class, args);
	}

}
