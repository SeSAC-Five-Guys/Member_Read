package com.sesac.member_read_server.member.persistence;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.sesac.member_read_server.member.document.Member;


@Repository
public interface MemberRepository extends ElasticsearchRepository<Member, Long> {
	Member findByEmail(String email);
}
