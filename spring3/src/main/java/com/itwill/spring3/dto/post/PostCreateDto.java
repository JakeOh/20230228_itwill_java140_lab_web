package com.itwill.spring3.dto.post;

import com.itwill.spring3.repository.post.Post;

import lombok.Data;

@Data
public class PostCreateDto {
    
    private String title;
    private String content;
    private String author;
    
    // DTO를 엔터티 객체로 변환해서 리턴하는 메서드:
    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
