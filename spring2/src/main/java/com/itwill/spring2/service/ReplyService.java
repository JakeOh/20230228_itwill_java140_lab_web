package com.itwill.spring2.service;

import org.springframework.stereotype.Service;

import com.itwill.spring2.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드를 초기화하는 생성자
@Service // 스프링 컨텍스트에 서비스 컴포넌트 객체로 등록
public class ReplyService {
    
    private final ReplyRepository replyRepository;

}
