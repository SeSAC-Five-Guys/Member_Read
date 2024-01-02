package com.sesac.member_read_server.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class LoginDto {

	@Pattern(regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[A-Za-z]+$", message = "잘못된 이메일 형식")
	@Size(max = 100, message = "이메일 길이 초과")
	@NotBlank(message = "이메일 공백 포함 불가")
	private String email;

	@Pattern(regexp = "^(?=.*[0-9a-zA-Z!@#$%&])[-0-9a-zA-Z!@#$%&]{6,12}$", message = "잘못된 비밀번호 형식")
	@NotBlank(message = "비밀번호 공백 포함 불가")
	private String password;
}
