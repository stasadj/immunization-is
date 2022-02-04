package com.immunization.trustee;

import com.immunization.common.CommonApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrusteeApplication extends CommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrusteeApplication.class, args);
	}

}
