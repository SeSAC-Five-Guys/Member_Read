package com.sesac.db_access_read.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberInfo {
	private String createdAt;
	private String updatedAt;
	private String deletedAt;

	private String email;
	private String phoneNumber;
	private String nickname;
	private String memberRole;
}
