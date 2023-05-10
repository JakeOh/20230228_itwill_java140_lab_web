package com.itwill.post.model;

import java.time.LocalDateTime;

// MVC 아키텍쳐에서 Model에 해당하는 클래스 - 데이터베이스 테이블에 매핑되는 클래스.
public class Post {
    // field
    private long id; // Primary Key
    private String title; // 글 제목
    private String content; // 글 내용
    private String author; // 글 작성자
    private LocalDateTime createdTime; // 글 최초 작성 시간
    private LocalDateTime modifiedTime; // 글 최종 수정 시간
    
    // constructor
    public Post() {}

    public Post(long id, String title, String content, String author, 
            LocalDateTime createdTime, LocalDateTime modifiedTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    // getters & setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + ", createdTime="
                + createdTime + ", modifiedTime=" + modifiedTime + "]";
    }
    
}
