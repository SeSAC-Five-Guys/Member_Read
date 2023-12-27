package com.sesac.db_access_read.member.document;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "member")
public class Member{
	@CreatedDate
	private String createdAt;

	@LastModifiedDate
	private String updatedAt;

	private String deletedAt;

	@Id
	private Long memberId;

	private String email;

	private String phoneNumber;

	private String password;

	private String nickname;

	private String memberRole;

	public void changePassword(String password){
		this.password = password;
	}

	public void changePhoneNum(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public void changeNickname(String nickname){
		this.nickname = nickname;
	}

	public void setDeletedAt(String deletedAt) { this.deletedAt = deletedAt; }
}
