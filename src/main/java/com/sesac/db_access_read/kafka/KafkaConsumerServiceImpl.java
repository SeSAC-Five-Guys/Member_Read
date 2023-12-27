package com.sesac.db_access_read.kafka;

import java.io.IOException;
import java.util.Map;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sesac.db_access_read.member.document.Member;
import com.sesac.db_access_read.member.persistence.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService {
	private final ElasticsearchOperations elasticsearchOperations;
	private final MemberRepository memberRepository;
	@KafkaListener(topics = "${variable.kafka.createMember}", groupId = "${spring.kafka.consumer.group-id}")
	@Transactional
	@Override
	public void createMemberListened(Map<String, String> registeredMember) throws IOException{

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

		log.info("Success saved CreateMember: " + member.getNickname());
	}

	@KafkaListener(topics = "${variable.kafka.updateMember}", groupId = "${spring.kafka.consumer.group-id}")
	@Transactional
	@Override
	public void updateMemberListened(Map<String, String> modifiedMember) throws IOException {
		Member member = memberRepository.findByEmail(modifiedMember.get("email"));
		member.changePhoneNum(modifiedMember.get("phoneNumber"));
		member.changeNickname(modifiedMember.get("nickname"));
		elasticsearchOperations.save(member);

		log.info("Success saved UpdateMember: " + member.getNickname());
	}

	@Override
	public void deleteMemberListened(Map<String, String> deletedMember) throws IOException {

	}

}
