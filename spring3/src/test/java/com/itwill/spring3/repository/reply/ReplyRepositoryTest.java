package com.itwill.spring3.repository.reply;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.spring3.repository.post.Post;
import com.itwill.spring3.repository.post.PostRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class ReplyRepositoryTest {
    
    @Autowired
    private ReplyRepository replyRepository;
    
    @Autowired
    private PostRepository postRepository;
    
//    @Test
    public void testFindById() {
        // 댓글 번호로 검색하기
        // select * from replies where id = 2
        Reply reply = replyRepository.findById(2L).orElseThrow();
        log.info(reply.toString());

        // findById() 메서드는
        // Reply 엔터티에서 FetchType.EAGER를 사용한 경우에는 join 문장을 실행.
        // FetchType.LAZY를 사용한 경우에는 단순 select 문장을 실행하고,
        // Post 엔터티가 필요한 경우에 (나중에) join 문장이 실행됨.
    }
    
    @Test
    public void testFindByPost() {
        // 포스트 아이디로 포스트 1개를 검색:
        Post post = postRepository.findById(1L).orElseThrow();
        
        // 해당 포스트에 달린 모든 댓글 검색:
        List<Reply> list = replyRepository.findByPostOrderByIdDesc(post);
        for (Reply r : list) {
            log.info(r.toString());
        }
    }

}
