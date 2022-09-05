/**
 * 
 */
package com.amdocs.media.assignement.profileservice.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author ikramshariff
 *
 */
@Service
public class KafkaProducer {
	
	private KafkaTemplate<String, String> kafkaTemplate;

	public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		
		this.kafkaTemplate = kafkaTemplate;
	}
	
	
	public void sendMessage(String message) {
		kafkaTemplate.send("exercise", message);
	}
	
	

}
