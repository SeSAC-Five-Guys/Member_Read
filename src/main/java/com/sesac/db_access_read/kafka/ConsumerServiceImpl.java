package com.sesac.db_access_read.kafka;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService{
	@KafkaListener(topics = "${variable.kafka.topicTest}", groupId = "${spring.kafka.consumer.group-id}")
	@Override
	public void testConsume(String message) throws IOException {
		System.out.println(String.format("Consumed TestMsg : %s", message));
	}
}
