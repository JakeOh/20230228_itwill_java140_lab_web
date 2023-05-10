package com.itwill.post.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import oracle.jdbc.OracleDriver;

// JUnit Test(자바 단위 테스트)를 하기 위한 클래스.
// JDBC(Java Database Connectivity) 테스트 - ojdbc11 라이브러리 동작 여부 테스트.
// main 메서드를 만들지 않고, 테스트 메서드를 작성하면,
// junit-jupiter-engine에서 테스트 메서드를 실행함.
public class JdbcTest {
    
    // Oracle 데이터베이스 접속 주소
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    // 데이터베이스 접속 계정
    private static final String USER = "scott";
    // 데이터베이스 접속 비밀번호
    private static final String PASSWORD = "tiger";
    
    // 테스트 메서드 작성:
    //   (0) @Test 애너테이션 사용.
    //   (1) 가시성: public.  (2) 리턴타입: void.  (3) 파라미터를 갖지 않음.
    //   테스트 성공/실패 여부는 테스트 메서드 작성자가 설정.
    
    @Test
    public void testSelect() throws SQLException {
        // 1. JDBC 라이브러리를 DriverManager에 등록.
        DriverManager.registerDriver(new OracleDriver());
        System.out.println("OJDBC 드라이버 등록 성공");
        
        // 2. 등록된 JDBC 드라이버를 사용해서 데이터베이스 서버에 접속.
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("conn: " + conn);
        
        // 데이터베이스와 연결된 접속을 해제.
        conn.close();
        System.out.println("연결 해제 성공.");
    }

}
