package com.jiyebackend.backendproject.board.controller;

import com.jiyebackend.backendproject.board.dto.MemberDTO;
import com.jiyebackend.backendproject.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/join")
    public String saveForm() {
        return "join";
    }

    @PostMapping("/join")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        memberService.join(memberDTO);
        return "index";
    }
}
