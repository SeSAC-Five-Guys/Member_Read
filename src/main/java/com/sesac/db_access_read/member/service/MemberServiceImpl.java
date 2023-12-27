package com.sesac.db_access_read.member.service;

import org.springframework.stereotype.Service;

import com.sesac.db_access_read.common.dto.ResDto;
import com.sesac.db_access_read.member.persistence.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{
	private final MemberRepository memberRepository;


}
