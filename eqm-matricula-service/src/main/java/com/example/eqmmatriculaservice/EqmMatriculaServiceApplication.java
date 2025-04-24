package com.example.eqmmatriculaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EqmMatriculaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EqmMatriculaServiceApplication.class, args);
		System.out.println("INICIADO CORRECTAMENTE");



	}

}
