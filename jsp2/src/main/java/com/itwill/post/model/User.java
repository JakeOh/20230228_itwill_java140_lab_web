package com.itwill.post.model;

// MVC 아키텍쳐에서 Model에 해당하는 클래스. VO(Value Object).
// DB의 USERS 테이블.
public class User {
    private long id; // Primary Key
    private String username;
    private String password;
    private String email;
    private long point;
    
    public User() {}

    public User(long id, String username, String password, String email, long point) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.point = point;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPoint() {
        return point;
    }

    public void setPoint(long point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", point="
                + point + "]";
    }
    
}
