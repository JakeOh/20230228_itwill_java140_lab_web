package com.itwill.spring3.repository.post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    // id 내림차순 정렬:
    // select * from POSTS order by ID desc
    List<Post> findByOrderByIdDesc();
    
}
