package com.itwill.spring1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j // Logger 객체(log)를 생성.
@Controller // Spring MVC 컴포넌트 애너테이션 중 하나. 
// Controller 컴포넌트라는 것을 dispatcherServlet에게 알려줌.
public class ExampleController {

    @GetMapping("/")
    public String home() {
        log.info("home()");
        
        return "index";
    }
    
}
