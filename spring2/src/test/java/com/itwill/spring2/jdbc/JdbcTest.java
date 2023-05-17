package com.itwill.spring2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.OracleDriver;

@Slf4j
@ExtendWith(SpringExtension.class) // Spring JUnit 테스트를 실행하는 메인 클래스.
@ContextConfiguration(
        locations = { "file:src/main/webapp/WEB-INF/application-context.xml" }
) // 스프링 컨텍스트 환경 설정 파일의 경로와 이름.
public class JdbcTest {

    @Test // JUnit 테스트 메서드
    public void testOjdbc() throws SQLException {
        // JDBC 1: JDBC 라이브러리를 등록
        DriverManager.registerDriver(new OracleDriver());
        log.info("Oracle JDBC 드라이버 등록 성공");
        
        // JDBC 2: Connection 객체 생성
        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String username = "scott";
        final String password = "tiger";
        
        Connection conn = DriverManager.getConnection(url, username, password);
        Assertions.assertNotNull(conn);
        //-> 단위 테스트 성공 조건: Connection 객체가 null이 아님.
        
        log.info("conn = {}", conn);
        
        // JDBC 3: 사용했던 리소스 해제
        conn.close();
        log.info("connection close 성공");
    }
    
}
