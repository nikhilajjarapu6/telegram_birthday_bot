package com.telegramAPI.service;

import java.io.File;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@Service
public class SubscriberService {
	private ObjectMapper mapper=new ObjectMapper();
	private Set<Long> subscribers=new CopyOnWriteArraySet<>();
	private File file=new File("subscribers.json");
	
	
	@PostConstruct
	private void init() {
		 try {
	            if (file.exists() && file.length() > 0) {
	                subscribers = mapper.readValue(file, new TypeReference<>() {});
	                System.out.println("✅ Loaded subscribers: " + subscribers.size());
	            } else {
	                System.out.println("ℹ️ No subscribers.json found, starting fresh.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	public void addSubscriber(Long chatId) {
	    if (subscribers.add(chatId)) { // Only if it wasn't already present
	        if (save()) {
	            System.out.println("✅ Added subscriber: " + chatId);
	        } else {
	            System.err.println("⚠️ Failed to save subscriber: " + chatId);
	        }
	    } else {
	        System.out.println("ℹ️ Subscriber already exists: " + chatId);
	    }
	}

	public void removeSubscriber(Long chatId) {
	    if (subscribers.remove(chatId)) { // Only if it was present
	        if (save()) {
	            System.out.println("❌ Removed subscriber: " + chatId);
	        } else {
	            System.err.println("⚠️ Failed to update JSON after removing: " + chatId);
	        }
	    } else {
	        System.out.println("ℹ️ Subscriber not found: " + chatId);
	    }
	}

	
	public Set<Long> getAllSubscribers(){
		return subscribers;
	}
	private boolean save() {
	    try {
	        mapper.writerWithDefaultPrettyPrinter().writeValue(file, subscribers);
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
}
