package com.Abarrotes.PVenta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.Abarrotes.PVenta"})
@EntityScan("com.Abarrotes.PVenta.Beans")
@EnableJpaRepositories("com.Abarrotes.PVenta.repository")

public class PVentaApplication 
{

	public static void main(String[] args) {
		SpringApplication.run(PVentaApplication.class, args);
	}

}
