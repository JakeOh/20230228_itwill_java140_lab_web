package com.itwill.spring3.dto.reply;

import lombok.Data;

@Data
public class ReplyCreateDto {
    
    private long postId;
    private String replyText;
    private String writer;

}
