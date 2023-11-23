package com.example.services.security;

import com.example.models.entities.Member;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {

    Member register(Member m);

    Member login (Member m);
}
