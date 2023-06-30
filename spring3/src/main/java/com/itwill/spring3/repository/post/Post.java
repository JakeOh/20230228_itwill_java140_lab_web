package com.itwill.spring3.repository.post;

import com.itwill.spring3.dto.post.PostUpdateDto;
import com.itwill.spring3.repository.BaseTimeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@Entity // JPA 엔터티 클래스 - 데이터베이스 테이블과 매핑되는 클래스.
@Table(name = "POSTS") // 엔터티 클래스 이름이 데이터베이스 테이블 이름과 다른 경우, 테이블 이름을 명시.
@SequenceGenerator(name = "POSTS_SEQ_GEN", sequenceName = "POSTS_SEQ", allocationSize = 1)
public class Post extends BaseTimeEntity {

    @Id // Primary key 제약조건
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POSTS_SEQ_GEN")
    private Long id;
    
    @Column(nullable = false) // Not Null 제약조건
    private String title;
    
    @Column(nullable = false)
    private String content;
    
    @Column(nullable = false)
    private String author;
    
    // Post 엔터티의 title과 content를 수정해서 리턴하는 메서드:
    public Post update(PostUpdateDto dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
        
        return this;
    }
    
}
