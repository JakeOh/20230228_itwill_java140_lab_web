package com.itwill.spring3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.spring3.dto.PostCreateDto;
import com.itwill.spring3.repository.post.Post;
import com.itwill.spring3.repository.post.PostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {
    
    // 생성자를 사용한 의존성 주입:
    private final PostRepository postRepository;
    
    // DB POSTS 테이블에서 전체 검색한 결과를 리턴: 
    public List<Post> read() {
        log.info("read()");
        
        return postRepository.findByOrderByIdDesc();
    }
    
    // DB POSTS 테이블에 엔터티를 삽입(insert):
    public Post create(PostCreateDto dto) {
        log.info("create(dto={})", dto);
        
        // DTO를 Entity로 변환:
        Post entity = dto.toEntity();
        log.info("entity={}", entity);
        
        // DB 테이블에 저장(insert)
        postRepository.save(entity);
        log.info("entity={}", entity);
        
        return entity;
    }

}
