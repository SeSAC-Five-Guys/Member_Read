package com.sesac.member_read_server.member.serviceUtil;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.sesac.member_read_server.common.dto.ErrorStatus;
import com.sesac.member_read_server.common.dto.ResDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class MemberServiceMakeResult {
	// 비지니스 로직의 Catch 절에서 500 에러에 대한 결과를 응답하는 메서드
	public ResDto makeInternalServerErrorResult(Exception e){
		log.error(e.getMessage());
		log.error(e.getCause());
		return ResDto.builder()
			.success(false)
			.errorStatus(ErrorStatus.INTERNAL_SERVER_ERROR)
			.build();
	}

	// 비지니스 로직 상의 응답에 대응되는 HTTP Status 반환하는 메서드
	public HttpStatus changeStatus(ResDto response) {
		if (!response.isSuccess()){
			return response.getErrorStatus().getHttpStatus();
		}
		return HttpStatus.OK;
	}
}
