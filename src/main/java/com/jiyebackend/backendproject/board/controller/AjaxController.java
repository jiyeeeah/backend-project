package com.jiyebackend.backendproject.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
    @GetMapping("/ex01")
    public String ex01() {
        System.out.println("AjaxController.ex01");
        // index.html로 이동하는게 아니라 그 내용을 긁어옴
        return "index"; // index.html에 작성된 내용 출력
    }

    @PostMapping("/ex02")
    public @ResponseBody String ex02() {
        System.out.println("AjaxController.ex21");
        return "index"; // 리턴값이 그대로 출력 ("index")
    }

    @GetMapping("/ex03")
    public @ResponseBody String ex03(@RequestParam("param1") String param1,
                                     @RequestParam("param2") String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
        return "ex03 메서드 호출 완료";

    }
    @PostMapping("/ex04")
    public @ResponseBody String ex04(@RequestParam("param1") String param1,
                                     @RequestParam("param2") String param2,
                                     @RequestParam("param3") String param3) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
        return "ex04 메서드 호출 완료";

    }
}
