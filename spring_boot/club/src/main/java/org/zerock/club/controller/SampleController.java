package org.zerock.club.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/sample/")
public class SampleController {

    @GetMapping("/all")
    public void exAll() { // 아무나 접근 가능
        log.info("exAll.........");
    }

    @GetMapping("/member")
    public void exMember() { // 회원만 접근 가능
        log.info("exMember.........");
    }

    @GetMapping("/admin")
    public void exAdmin() { // 회원중에 admin 권한이 있는 사람만 접근 가능
        log.info("exAdmin.........");
    }
}
