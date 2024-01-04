package com.sesac.member_read_server.kafka;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;

public class KafkaTestConsumerServiceImpl {
	@KafkaListener(topics = "${variable.kafka.topicTest}", groupId = "${spring.kafka.consumer.group-id}")
	public void testConsume(String message) throws IOException {
		System.out.println(String.format("Consumed TestMsg : %s", message));
	}
}
