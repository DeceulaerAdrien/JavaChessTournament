package com.example.controllers.security;

import com.example.models.dtos.security.MemberTokenDTO;
import com.example.models.entities.Member;

import com.example.models.forms.security.MemberLoginForm;
import com.example.models.forms.security.MemberRegisterForm;
import com.example.services.security.MemberService;
import com.example.utils.BCryptUtils;
import com.example.utils.JwtUtils;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@CrossOrigin("*")
public class MemberController {
    private final MemberService memberService;
    private final JwtUtils jwtUtils;

    public MemberController(MemberService memberService, JwtUtils jwtUtils) {
        this.memberService = memberService;
        this.jwtUtils = jwtUtils;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/register")
    public ResponseEntity<MemberTokenDTO> register(
            @RequestBody @Valid MemberRegisterForm form
    ) {
        Member member = memberService.register(form.toEntity());
//        String token = jwtUtils.generateToken(member);
        MemberTokenDTO dto = MemberTokenDTO.fromEntity(member);
//        dto.setToken(token);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/login")
    public ResponseEntity<MemberTokenDTO> login(
            @RequestBody MemberLoginForm form
    ) {
        Member member = memberService.login(form.toEntity());
        String token = jwtUtils.generateToken(member);
        MemberTokenDTO dto = MemberTokenDTO.fromEntity(member);
        dto.setToken(token);
        return ResponseEntity.ok(dto);
    }
}