package com.itwill.spring3.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.spring3.repository.reply.Reply;
import com.itwill.spring3.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reply")
public class ReplyRestController {
    
    private final ReplyService replyService;
    
    @GetMapping("/all/{postId}")
    public ResponseEntity<List<Reply>> all(@PathVariable long postId) {
        log.info("all(postId={})", postId);
        
        List<Reply> list = replyService.read(postId);
        
        // 클라이언트로 댓글 리스트를 응답으로 보냄.
        return ResponseEntity.ok(list);
    }

}
