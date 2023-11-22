//package com.example.controllers;
//
//import com.example.models.entities.Member;
//import com.example.services.MemberService;
//import jakarta.validation.Valid;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("member")
//public class MemberController {
//    private final MemberService memberService;
//
//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }
//
////    @PreAuthorize("hasAutorithy('ADMIN')")
////    @PostMapping
////    public ResponseEntity<Member> create(@RequestBody @Valid )
////
//}
