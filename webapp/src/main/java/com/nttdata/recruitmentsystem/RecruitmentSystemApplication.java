package com.nttdata.recruitmentsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.nttdata.recruitmentsystem")
@EnableJpaRepositories(basePackages = "com.nttdata.recruitmentsystem")
public class RecruitmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruitmentSystemApplication.class, args);
	}

}
