package br.com.vitormelonunes.toll_notifications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TollNotificationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TollNotificationsApplication.class, args);
	}

}
