package com.example.services.impl;

import com.example.exceptions.member.AlreadyExistMemberException;
import com.example.models.entities.Member;
import com.example.repositories.MemberRepository;
import com.example.services.MemberService;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member create(Member member) {
        if (memberRepository.existsByUsername(member.getUsername())){
            throw new AlreadyExistMemberException();
        }

        return memberRepository.save(member);
    }
}
