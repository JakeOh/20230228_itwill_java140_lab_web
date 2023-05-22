package com.itwill.spring2.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.itwill.spring2.domain.Reply;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        locations = { "file:src/main/webapp/WEB-INF/application-context.xml" }
)
public class ReplyRepositoryTest {
    
    // Repository 객체를 주입받음(의존성 주입, DI)
    @Autowired
    private ReplyRepository replyRepository;
    
    @Test
    public void testReplyCount() {
        long result = replyRepository.selectReplyCountWithPostId(0);
        log.info("result = {}", result);
    }
    
//    @Test
    public void testDelete() {
        int result = replyRepository.delete(1);
        log.info("result = {}", result);
    }
    
//    @Test
    public void testUpdate() {
        Reply entity = Reply.builder()
                .id(1)
                .reply_text("댓글 수정 test")
                .build();
        int result = replyRepository.update(entity);
        log.info("result = {}", result);
    }
    
//    @Test
    public void testInsert() {
        Reply entity = Reply.builder()
                .reply_text("JUnit test")
                .writer("guest")
                .post_id(3)
                .build();
        int result = replyRepository.insert(entity);
        log.info("result = {}", result);
    }
    
//    @Test
    public void test() {
        Assertions.assertNotNull(replyRepository);
        log.info(replyRepository.toString());
        
        List<Reply> list = replyRepository.selectByPostId(1);
        for(Reply reply : list) {
            log.info(reply.toString());
        }
    }

}
