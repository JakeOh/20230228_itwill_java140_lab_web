package com.itwill.spring3.web;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.spring3.dto.post.PostCreateDto;
import com.itwill.spring3.dto.post.PostSearchDto;
import com.itwill.spring3.dto.post.PostUpdateDto;
import com.itwill.spring3.repository.post.Post;
import com.itwill.spring3.service.PostService;
import com.itwill.spring3.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/post")
public class PostController {
    
    private final PostService postService;
    private final ReplyService replyService;
    
    @GetMapping
    public String read(Model model) {
        log.info("read()");
        
        // 포스트 목록 검색:
        List<Post> list = postService.read();
        
        // Model에 검색 결과를 세팅:
        model.addAttribute("posts", list);
        
        return "/post/read";
    }
    
    @PreAuthorize("hasRole('USER')") // 페이지 접근 이전에 인증(권한, 로그인) 여부를 확인.
    @GetMapping("/create")
    public void create() {
        log.info("creat() GET");
        
        // 리턴값이 없는 경우 view의 이름은 요청 주소와 같음.
    }
    
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/create")
    public String create(PostCreateDto dto) {
        log.info("create(dto={}) POST", dto);
        
        // form에서 submit(제출)된 내용을 DB 테이블에 insert
        postService.create(dto);
        
        // DB 테이블 insert 후 포스트 목록 페이지로 redirect 이동.
        return "redirect:/post";
    }
    
    // "/post/details", "/post/modify" 요청 주소들을 처리하는 컨트롤러 메서드.
    @PreAuthorize("hasRole('USER')")
    @GetMapping({ "/details", "/modify" })
    public void read(Long id, Model model) {
        log.info("read(id={})", id);
        
        // POSTS 테이블에서 id에 해당하는 포스트를 검색.
        Post post = postService.read(id);
        
        // 결과를 model에 저장 -> 뷰로 전달됨.
        model.addAttribute("post", post);
        
        // REPLIES 테이블에서 해당 포스트에 달린 댓글 개수를 검색.
        long count = replyService.countByPost(post);
        model.addAttribute("replyCount", count);
        
        // 컨트롤러 메서드의 리턴값이 없는 경우(void인 경우),
        // 뷰의 이름은 요청 주소와 같다!
        // details -> details.html, modify -> modify.html
    }
    
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/delete")
    public String delete(Long id) {
        log.info("delete(id={})", id);
        
        // postService를 이용해서 DB 테이블에서 포스트를 삭제하는 서비스 호출:
        postService.delete(id);
        
        return "redirect:/post";
    }
    
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/update")
    public String update(PostUpdateDto dto) {
        log.info("update(dto={})", dto);
        
        // 포스트 업데이트 서비스 호출:
        postService.update(dto);
        
        return "redirect:/post/details?id=" + dto.getId();
    }
    
    @GetMapping("/search")
    public String search(PostSearchDto dto, Model model) {
        log.info("search(dto={})", dto);
        
        // postService의 검색 기능 호출:
        List<Post> list = postService.search(dto);

        // 검색 결과를 Model에 저장해서 뷰로 전달:
        model.addAttribute("posts", list);
        
        return "/post/read";
    }

}
