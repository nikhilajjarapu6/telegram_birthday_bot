package com.telegramAPI;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import jakarta.annotation.PostConstruct;

@Component
public class RegisterBot {
    private final Countdown countdown;
    private static boolean registered = false;

    public RegisterBot(Countdown countdown) {
        this.countdown = countdown;
    }

    @PostConstruct
    public void registerBot() throws Exception {
        if (!registered) {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(countdown);
            registered = true;
            System.out.println("✅ Bot registered once.");
        } else {
            System.out.println("⚠️ Bot already registered, skipping...");
        }
    }
}
