package com.itwill.spring2.stream;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

// 스프링 컨텍스트(application-context.xml 또는 servlet-context.xml)를 사용하지 않는
// 단위 테스트에서는 @ExtendWith, @ContextConfiguration 애너테이션을 사용할 필요가 없음.
public class StreamTest {

    @Test
    public void test() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(numbers);
        
        // numbers에서 홀수들만 필터링한 결과:
        List<Integer> odds = numbers.stream()
                .filter((x) -> x % 2 == 1)
                .toList();
        System.out.println(odds);
        
        // numbers의 원소의 제곱들로 이루어진 리스트
        List<Integer> squares = numbers.stream()
                .map((x) -> x * x)
                .toList();
        System.out.println(squares);
        
        // numbers의 원소들 중 홀수들의 제곱
        List<Integer> oddSquares = numbers.stream()
                .filter((x) -> x % 2 == 1)
                .map((x) -> x * x)
                .toList();
        System.out.println(oddSquares);
        
        List<String> languages = Arrays.asList("Java", "SQL", "JavaScript");
        System.out.println(languages);
        
        // languages가 가지고 있는 문자열들의 길이를 원소로 갖는 리스트 
        List<Integer> lengths = languages.stream()
                .map(String::length) // (x) -> x.length()
                .toList();
        System.out.println(lengths);
        
        List<LocalDateTime> times = Arrays.asList(
                LocalDateTime.of(2023, 5, 23, 11, 30, 0),
                LocalDateTime.of(2023, 5, 24, 12, 30, 0),
                LocalDateTime.of(2023, 5, 25, 18, 00, 0)
        );
        System.out.println(times);
        
        // LocalDateTime 타입을 Timestamp 타입으로 변환
        List<Timestamp> timestamps = times.stream()
                .map(Timestamp::valueOf) // (x) -> Timestamp.valueOf(x)
                .toList();
        System.out.println(timestamps);
    }
    
}
