package com.sesac.member_read_server.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesac.member_read_server.common.dto.ResDto;
import com.sesac.member_read_server.member.service.MemberService;
import com.sesac.member_read_server.member.serviceUtil.MemberServiceMakeResult;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/v1/members")
public class MemberController {
	private final MemberService memberService;
	private final MemberServiceMakeResult makeResult;

	@GetMapping("/member/{email}")
	public ResponseEntity<ResDto> readSingleMember(
		@Valid
		@Pattern(regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[A-Za-z]+$", message = "잘못된 이메일 형식")
		@Size(max = 100, message = "이메일 길이 초과")
		@NotBlank(message = "이메일 공백 포함 불가")
		@PathVariable("email") String email
	){
		ResDto response = memberService.readSingleMember(email);
		HttpStatus status = makeResult.changeStatus(response);
		return new ResponseEntity<>(response, status);
	}
}
