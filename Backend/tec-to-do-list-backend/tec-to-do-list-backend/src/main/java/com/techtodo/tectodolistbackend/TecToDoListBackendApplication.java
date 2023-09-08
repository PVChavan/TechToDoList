package com.techtodo.tectodolistbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages= {" package com.techtodo.tectodolistbackend.controller;","package com.techtodo.tectodolistbackend.service;"})
@EntityScan(basePackages= {"package com.techtodo.tectodolistbackend.entity;"})
@EnableJpaRepositories(basePackages= {"package com.techtodo.tectodolistbackend.repository;"})
public class TecToDoListBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TecToDoListBackendApplication.class, args);
	}

}
