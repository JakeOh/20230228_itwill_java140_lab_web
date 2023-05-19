package com.itwill.spring2.dto;

import java.sql.Timestamp;

import com.itwill.spring2.domain.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Getter
@ToString
public class PostListDto {
    
    private long id;
    private String title;
    private String author;
    private Timestamp createdTime;
    
    // Post 타입의 객체를 PostListDto 타입의 객체로 변환해서 리턴하는 메서드.
    public static PostListDto fromEntity(Post entity) {
        return PostListDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .createdTime(Timestamp.valueOf(entity.getCreated_time()))
                .build();
    }

}
