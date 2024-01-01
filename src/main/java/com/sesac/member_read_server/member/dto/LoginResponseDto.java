package com.sesac.member_read_server.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponseDto {
	private String createdAt;
	private String updatedAt;
	private String deletedAt;

	private String email;
	private String phoneNumber;
	private String nickname;
	private String memberRole;
}
