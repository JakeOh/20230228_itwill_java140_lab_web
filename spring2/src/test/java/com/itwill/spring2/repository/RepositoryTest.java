package com.itwill.spring2.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.itwill.spring2.domain.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        locations = { "file:src/main/webapp/WEB-INF/application-context.xml" }
)
public class RepositoryTest {
    
    @Autowired
    private PostRepository postRepository;
    
    @Test
    public void testPostRepository() {
        Assertions.assertNotNull(postRepository);
        log.info("postRepository = {}", postRepository);
        
        Post post = Post.builder()
                .title("Lombok 테스트")
                .content("Lombok 라이브러리를 이용한 Builder 패턴 구현")
                .author("admin")
                .build();
        log.info(post.toString());
        
        int result = postRepository.insert(post);
        Assertions.assertEquals(1, result);
        log.info("result = {}", result);
        
    }

}
