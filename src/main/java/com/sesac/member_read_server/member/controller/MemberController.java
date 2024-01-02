package com.sesac.member_read_server.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sesac.member_read_server.common.dto.ResDto;
import com.sesac.member_read_server.member.dto.LoginDto;
import com.sesac.member_read_server.member.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/members")
public class MemberController {
	private final MemberService memberService;

	@ResponseBody
	@GetMapping("/member")
	public ResponseEntity<ResDto> readSingleMember_login(
		@Valid @RequestBody LoginDto loginInfo
	){
		ResDto response = memberService.readSingleMember_login(loginInfo.getEmail(), loginInfo.getPassword());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
