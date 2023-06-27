package com.itwill.spring3.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.spring3.repository.post.Post;
import com.itwill.spring3.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/post")
public class PostController {
    
    private final PostService postService;
    
    @GetMapping
    public String read(Model model) {
        log.info("read()");
        
        // 포스트 목록 검색:
        List<Post> list = postService.read();
        
        // Model에 검색 결과를 세팅:
        model.addAttribute("posts", list);
        
        return "/post/read";
    }
    
    @GetMapping("/create")
    public void create() {
        log.info("creat() GET");
        
        // 리턴값이 없는 경우 view의 이름은 요청 주소와 같음.
    }

}
