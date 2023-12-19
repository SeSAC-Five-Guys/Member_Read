package com.sesac.db_access_read.kafka;

import java.io.IOException;

import org.springframework.stereotype.Service;

public interface ConsumerService {
	public void testConsume(String message) throws IOException;
}
