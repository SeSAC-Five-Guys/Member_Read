package com.sesac.member_read_server.member.service;

import org.springframework.stereotype.Service;

import com.sesac.member_read_server.common.dto.ErrorStatus;
import com.sesac.member_read_server.common.dto.ResDto;
import com.sesac.member_read_server.member.document.Member;
import com.sesac.member_read_server.member.dto.LoginResponseDto;
import com.sesac.member_read_server.member.persistence.MemberRepository;
import com.sesac.member_read_server.member.serviceUtil.MemberServiceMakeResult;
import com.sesac.member_read_server.member.serviceUtil.MemberServiceValidating;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{
	private final MemberRepository memberRepository;
	private final MemberServiceMakeResult makeResult;
	private final MemberServiceValidating validating;
	@Override
	public ResDto readSingleMember(String email, String password) {
		try {
			Member existMember = memberRepository.findByEmail(email);
			if(existMember == null){
				return ResDto.builder()
					.success(false)
					.tmpSvcRes(ErrorStatus.NOT_EXIST_EMAIL.getStatus())
					.errorStatus(ErrorStatus.NOT_EXIST_EMAIL)
					.build();
			}

			if(!(existMember.getDeletedAt() == null)){
				return ResDto.builder()
					.success(false)
					.tmpSvcRes(ErrorStatus.NOT_EXIST_EMAIL.getStatus())
					.errorStatus(ErrorStatus.NOT_EXIST_EMAIL)
					.build();
			}

			if(!validating.isMatch(password, existMember.getPassword())){
				return ResDto.builder()
					.success(false)
					.tmpSvcRes(ErrorStatus.NOT_EXIST_PW.getStatus())
					.errorStatus(ErrorStatus.NOT_EXIST_PW)
					.build();
			}

			LoginResponseDto memberInfo = LoginResponseDto.builder()
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
