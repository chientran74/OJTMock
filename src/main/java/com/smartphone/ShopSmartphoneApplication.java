package com.smartphone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@SpringBootApplication
public class ShopSmartphoneApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ShopSmartphoneApplication.class, args);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String p = "123";
		System.out.println(encoder.encode(p));
	}
	

	

}
