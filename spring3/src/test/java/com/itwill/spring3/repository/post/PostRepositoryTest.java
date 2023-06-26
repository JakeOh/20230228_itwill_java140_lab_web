package com.itwill.spring3.repository.post;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;
    
    @Test
    public void testFindAll() {
        List<Post> list = postRepository.findByOrderByIdDesc();
        for (Post p : list) {
            log.info(p.toString());
        }
    }
    
//    @Test
    
}
