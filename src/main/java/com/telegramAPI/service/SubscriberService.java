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
		subscribers.add(chatId);
		//method to store subscriber into JSON
		save();
	}
	

	public void removeSubscriber(Long chatId) {
		subscribers.remove(chatId);
	}
	
	public Set<Long> getAllSubscribers(){
		return subscribers;
	}
	private void save() {
		 try {
	            mapper.writerWithDefaultPrettyPrinter().writeValue(file, subscribers);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
}
