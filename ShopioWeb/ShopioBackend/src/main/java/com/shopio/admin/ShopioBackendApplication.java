package com.shopio.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.shopio.common.entity","com.shopio.admin.user"}) //scan jpa entities:Role,RoleRepository
public class ShopioBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopioBackendApplication.class, args);
	}

}
