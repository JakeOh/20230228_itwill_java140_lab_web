package com.itwill.post.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class EncodingFilter
 */
public class EncodingFilter extends HttpFilter implements Filter {

    // Slf4j 로깅 기능:
    private static final Logger log = LoggerFactory.getLogger(EncodingFilter.class);
    
    // 생성자
    public EncodingFilter () {
        log.info("EncodingFilter 생성자 호출");
    }
    
	/**
	 * @see Filter#destroy()
	 */
	@Override
    public void destroy() {
		// Filter 객체를 메모리에서 제거할 때 WAS가 호출하는 생명주기(life cycle)메서드.
	    // Filter 객체가 소멸될 때 리소스 해제와 같은 작업이 필요하면 해당 작업들을 수행함.
	    log.info("destroy() 호출");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
	        throws IOException, ServletException {
		log.info("doFilter() : chain.doFilter() 호출 전");

		// 클라이언트에서 온 요청을 컨트롤러(서블릿)에게 전달하기 전에 실행할 코드들을 작성.

		// 요청을 필터체인의 그 다음 단계로 전달 -> 컨트롤러 메서드가 호출됨.
		chain.doFilter(request, response);
		
		log.info("doFilter() : chain.doFilter() 호출 후");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// 필터 객체가 생성된 후 초기화(initialization) 작업이 필요할 때 
	    // WAS가 호출하는 생명주기 메서드.
	    log.info("init() 호출");
	}

}
