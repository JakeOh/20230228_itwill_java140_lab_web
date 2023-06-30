package com.itwill.spring3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration // 스프링 컨테이너에서 빈(bean)으로 생성, 관리 - 필요한 곳에 의존성 주입.
public class SecurityConfig {
    
    // Spring Security 5 버전부터는 비밀번호는 반드시 암호화를 해야 함.
    // 비밀번호를 암호화하지 않으면 HTTP 403(access denied, 접근 거부) 또는
    // HTTP 500(internal server error, 내부 서버 오류)가 발생함.
    // 비밀번호 인코더(Password encoder) 객체를 bean으로 생성해야 함.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    // 로그인할 때 사용할 임시 사용자(메모리에 임시 저장) 생성
    @Bean
    public UserDetailsService inMemoryUserDetailsService() {
        // 사용자 상세 정보
        UserDetails user1 = User
                .withUsername("user1") // 로그인할 때 사용할 사용자 이름(아이디)
                .password(passwordEncoder().encode("1111")) // 로그인할 때 사용할 비밀번호
                .roles("USER") // 사용자 권한(USER, ADMIN, ...)
                .build(); // UserDetails 객체 생성.
        
        UserDetails user2 = User
                .withUsername("user2")
                .password(passwordEncoder().encode("2222"))
                .roles("USER", "ADMIN")
                .build();
        
        UserDetails user3 = User
                .withUsername("user3")
                .password(passwordEncoder().encode("3333"))
                .roles("ADMIN")
                .build();
        
        return new InMemoryUserDetailsManager(user1, user2, user3);
    }

}
