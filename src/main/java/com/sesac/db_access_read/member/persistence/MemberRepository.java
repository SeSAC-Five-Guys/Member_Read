package com.sesac.db_access_read.member.persistence;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.sesac.db_access_read.member.document.Member;


@Repository
public interface MemberRepository extends ElasticsearchRepository<Member, Long> {
	Member findByEmail(String email);
}
