package com.itwill.spring2.repository;

import java.util.List;

import com.itwill.spring2.domain.Reply;

public interface ReplyRepository {

    List<Reply> selectByPostId(long postId);
    Reply selectById(long id);
    int insert(Reply reply);
    int update(Reply reply);
    int delete(long id);
    
    // 포스트에 달린 댓글의 개수를 리턴하는 메서드
    long selectReplyCountWithPostId(long postId);
    
}
