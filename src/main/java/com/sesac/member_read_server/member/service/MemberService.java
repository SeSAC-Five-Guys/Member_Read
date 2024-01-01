package com.sesac.member_read_server.member.service;

import com.sesac.member_read_server.common.dto.ResDto;

public interface MemberService {
	ResDto readSingleMember(String email, String password);
}
