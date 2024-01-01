package com.sesac.member_read_server.member.serviceUtil;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceValidating {
	public boolean isMatch(String rawPassword, String encodedPassword){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(rawPassword, encodedPassword);
	}
}
