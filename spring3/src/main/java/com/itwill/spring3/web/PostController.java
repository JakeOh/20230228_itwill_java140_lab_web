package com.itwill.spring3.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/post")
public class PostController {
    
    @GetMapping
    public String read() {
        log.info("post()");
        
        // TODO: 포스트 목록 검색
        
        return "/post/read";
    }
    
    @GetMapping("/create")
    public void create() {
        log.info("creat() GET");
    }

}
