package com.itwill.spring2.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 댓글 테이블(REPLIES)에 저장되는 레코드(행 1개)를 표현하는 객체.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply {
    
    private long id; // 댓글 아이디. primary key.
    private long post_id; // 댓글이 달린 포스트의 아이디. foreign key
    private String reply_text; // 댓글 내용.
    private String writer; // 댓글 작성자 아이디.
    private LocalDateTime created_time; // 댓글 작성 시간.
    private LocalDateTime modified_time; // 댓글 수정 시간.

}
