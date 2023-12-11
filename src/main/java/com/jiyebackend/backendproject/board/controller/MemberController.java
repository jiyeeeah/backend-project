package com.jiyebackend.backendproject.board.controller;

import com.jiyebackend.backendproject.board.dto.MemberDTO;
import com.jiyebackend.backendproject.board.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return "login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO loginResult = memberService.login(memberDTO);
        if(loginResult != null) {
            // login 성공
            session.setAttribute("loginEmail", loginResult.getMemberEmail());
            return "main";
        } else {
            // login 실패
            return "login";
        }
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        // 어떠한 html로 가져갈 데이터가 있다면 model사용
        model.addAttribute("memberList", memberDTOList);
        return "memberList";
    }
}
