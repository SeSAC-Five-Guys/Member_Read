package com.sesac.member_read_server.member.service;

import org.springframework.stereotype.Service;

import com.sesac.member_read_server.common.dto.ResDto;
import com.sesac.member_read_server.member.document.Member;
import com.sesac.member_read_server.member.dto.MemberInfo;
import com.sesac.member_read_server.member.persistence.MemberRepository;
import com.sesac.member_read_server.member.serviceUtil.MemberServiceMakeResult;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{
	private final MemberRepository memberRepository;
	private final MemberServiceMakeResult makeResult;
	@Override
	public ResDto readSingleMember(String email) {
		try {
			Member existMember = memberRepository.findByEmail(email);

			MemberInfo memberInfo = MemberInfo.builder()
				.email(existMember.getEmail())
				.phoneNumber(existMember.getPhoneNumber())
				.nickname(existMember.getNickname())
				.memberRole(existMember.getMemberRole())
				.build();

			return ResDto.builder()
				.success(true)
				.data(memberInfo)
				.build();
		}catch (Exception e){
			return makeResult.makeInternalServerErrorResult(e);
		}
	}
}
