package com.example.services.impl;

import com.example.models.entities.Member;
import com.example.repositories.MemberRepository;
import com.example.services.MemberService;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member create(Member member) {
        return null;
    }
}
