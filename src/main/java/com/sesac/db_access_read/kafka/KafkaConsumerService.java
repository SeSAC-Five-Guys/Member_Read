package com.sesac.db_access_read.kafka;

import java.io.IOException;
import java.util.Map;

public interface KafkaConsumerService {
	public void createMemberListened(Map<String, String> registeredMember) throws IOException;

	public void updateMemberListened(Map<String, String> modifiedMember) throws IOException;

	public void deleteMemberListened(Map<String, String> deletedMember) throws IOException;
}
