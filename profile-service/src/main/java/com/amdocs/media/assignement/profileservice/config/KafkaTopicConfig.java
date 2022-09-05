/**
 * 
 */
package com.amdocs.media.assignement.profileservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author ikramshariff
 *
 */
@Configuration
public class KafkaTopicConfig {
	
	@Bean
	public NewTopic createKafkaTopic() {
		return TopicBuilder.name("exercise").build();
	}

}