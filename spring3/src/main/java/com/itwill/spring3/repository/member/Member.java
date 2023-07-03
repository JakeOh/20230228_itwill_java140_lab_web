package com.itwill.spring3.repository.member;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.itwill.spring3.repository.BaseTimeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "MEMBERS")
@SequenceGenerator(name = "MEMBERS_SEQ_GEN", sequenceName = "MEMBERS_SEQ", allocationSize = 1)
// Member IS-A UserDetails
// 스프링 시큐리티는 로그인 처리를 위해서 UserDetails 객체를 사용하기 때문에
// 회원 정보 엔터티는 UserDetails 인터페이스를 구현해야 함.
public class Member extends BaseTimeEntity implements UserDetails {
    
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBERS_SEQ_GEN")
    private Long id;
    
    @Column(nullable = false, unique = true) // NOT NULL, UNIQUE 제약 조건
    private String username;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private Role role;

    @Builder
    private Member(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = Role.USER; // 회원 가입 사용자 권한의 기본값은 USER
    }

    // UserDetails 인터페이스의 추상 메서드들을 구현:
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // ROLE_USER 권한을 갖음.
        return Arrays.asList(new SimpleGrantedAuthority(role.getKey()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 계정(account)이 non-expired(만료되지 않음).
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 계정이 non-lock(잠기지 않음).
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 비밀번호가 non-expired.
    }

    @Override
    public boolean isEnabled() {
        return true; // 사용자 상세정보(UserDetails)가 활성화(enable).
    }
    
}
