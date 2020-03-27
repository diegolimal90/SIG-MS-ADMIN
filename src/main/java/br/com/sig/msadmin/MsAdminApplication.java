package br.com.sig.msadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAdminApplication.class, args);
	}

}
