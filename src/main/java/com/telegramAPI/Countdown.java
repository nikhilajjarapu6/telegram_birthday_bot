package com.telegramAPI;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.telegramAPI.service.SubscriberService;


@Component
public class Countdown extends TelegramLongPollingBot {

    @Value("${telegram.bot.token}")
    private String token;

    @Value("${telegram.bot.username}")
    private String botUsername;

    @Value("${telegram.bot.birthday}")
    private String birthdayString;

    private LocalDate birthday;
//    private final Set<Long> chatIds = new CopyOnWriteArraySet<>();
    
    private  SubscriberService service;
    
 
    public Countdown(SubscriberService service) {
		this.service = service;
	}

	@Override
    public String getBotToken() {
        return token;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Long chatId = update.getMessage().getChatId();
            String text = update.getMessage().getText().trim();

            if ("/start".equalsIgnoreCase(text)) {
//                chatIds.add(chatId);
                service.addSubscriber(chatId);
                sendMessage(chatId, "✅ Welcome to Bat Bot! You are now subscribed.");
            } else if ("/stop".equalsIgnoreCase(text)) {
//                chatIds.remove(chatId);
                service.removeSubscriber(chatId);
                sendMessage(chatId, "⛔ Stopped. You will no longer receive daily messages.");
            } else if("hi".equalsIgnoreCase(text)) {
            	sendMessage(chatId, "Hiii. This is Batman from gotham");
            }
            
            else {
                sendMessage(chatId, "ℹ️ Send /start to subscribe or /stop to unsubscribe.");
            }
        }
    }

    private void sendMessage(Long chatId, String text) {
        try {
            execute(SendMessage.builder()
                    .chatId(String.valueOf(chatId))
                    .text(text)
                    .build());
        } catch (Exception e) {
        	System.out.println("❌ Failed to send message to chatId " + chatId + ": " + e.getMessage());
        }
    }

  
    @Scheduled(cron = "0 00 9 * * ?", zone = "Asia/Kolkata")
    public void sendCountdown() {
        if (birthday == null) {
            birthday = LocalDate.parse(birthdayString);
        }

        long daysLeft = LocalDate.now().until(birthday, ChronoUnit.DAYS);

        String message = (daysLeft > 0)
                ? "🎂 Countdown: " + daysLeft + " days left until the Birthday!"
                : "🎉 Today is the Birthday!";

        for (Long id : service.getAllSubscribers()) {
            sendMessage(id, message);
        }
    }
}
