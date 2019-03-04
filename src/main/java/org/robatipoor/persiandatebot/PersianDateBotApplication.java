package org.robatipoor.persiandatebot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;

@SpringBootApplication
public class PersianDateBotApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PersianDateBotApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApiContextInitializer.init();
        TelegramBotsApi tb = new TelegramBotsApi();
        try {
            tb.registerBot(new CommandsHandler(System.getenv("USERNAME_BOT")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Start Bot !");
	}
}
