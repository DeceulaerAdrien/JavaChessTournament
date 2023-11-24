package com.example.services.security.impl;


import com.example.exceptions.member.AlreadyExistMemberException;
import com.example.models.entities.Member;
import com.example.repositories.security.MemberRepository;
import com.example.services.MemberService;
import com.example.utils.BCryptUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private final BCryptUtils bCryptUtils;

    public MemberServiceImpl(MemberRepository memberRepository, BCryptUtils bCryptUtils) {
        this.memberRepository = memberRepository;
        this.bCryptUtils = bCryptUtils;
    }

    @Override
    public Member register(Member member) {
        if (memberRepository.existsByUsername(member.getUsername())) {
            throw new AlreadyExistMemberException();
        }
        String hashedPassword = bCryptUtils.hash(member.getPassword());
        member.setPassword(hashedPassword);
        return memberRepository.save(member);
    }

    @Override
    public Member login(Member member) {
        Member existingMember = memberRepository.findByUsername(member.getUsername()).orElseThrow();
        if (!bCryptUtils.verify(member.getPassword(), existingMember.getPassword())) {
            throw new RuntimeException("Wrong Password");
        }
        return existingMember;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}