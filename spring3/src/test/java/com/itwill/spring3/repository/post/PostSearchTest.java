package com.itwill.spring3.repository.post;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PostSearchTest {
    
    @Autowired
    private PostRepository postRepository;
    
    @Test
    public void testSearch() {
        List<Post> list = postRepository
//                .findByTitleContainsIgnoreCaseOrderByIdDesc("TE");
//                .findByContentContainsIgnoreCaseOrderByIdDesc("테");
//                .findByTitleContainsIgnoreCaseOrContentContainsIgnoreCaseOrderByIdDesc("테", "테");
                .searchByKeyword("te");
        for (Post p : list) {
            log.info(p.toString());
        }
    }

}
