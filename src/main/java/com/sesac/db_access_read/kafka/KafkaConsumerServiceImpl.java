package com.sesac.db_access_read.kafka;

import java.io.IOException;
import java.util.Map;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.sesac.db_access_read.member.document.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService {
	private final ElasticsearchOperations elasticsearchOperations;
	@KafkaListener(topics = "${variable.kafka.createMember}", groupId = "${spring.kafka.consumer.group-id}")
	@Override
	public void createMemberListened(Map<String, String> registeredMember) throws IOException{
		System.out.println(registeredMember);
		Member member = Member.builder()
			.memberId(Long.parseLong(registeredMember.get("memberId")))
			.createdAt(registeredMember.get("createdAt"))
			.updatedAt(registeredMember.get("updatedAt"))
			.email(registeredMember.get("email"))
			.phoneNumber(registeredMember.get("phoneNumber"))
			.nickname(registeredMember.get("nickname"))
			.memberRole(registeredMember.get("memberRole"))
			.password(registeredMember.get("password"))
			.build();
		elasticsearchOperations.save(member);
	}
}
