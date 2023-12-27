package com.sesac.db_access_read.member.service;

import com.sesac.db_access_read.common.dto.ResDto;

public interface MemberService {
	ResDto readSingleMember(String email);
}
