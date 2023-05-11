package com.itwill.post.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.post.model.Post;

public class PostDaoTest {
    private static final Logger log = LoggerFactory.getLogger(PostDaoTest.class);
    
    @Test
    public void testSelect() {
        PostDao dao = PostDao.getInstance();
        List<Post> list = dao.select();
        Assertions.assertNotEquals(0, list.size());
        
        for (Post p : list) {
            log.info(p.toString());
        }
    }

}
