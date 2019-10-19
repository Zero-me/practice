package com.zero.filter ;

import java.io.IOException ;
import java.io.OutputStream ;
import javax.servlet.FilterChain ;
import javax.servlet.http.HttpServletRequest ;
import javax.servlet.http.HttpServletResponse ;
import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;
import org.springframework.web.filter.OncePerRequestFilter ;
import com.zero.entity.ResultBean ;
import com.zero.exception.UserAuthException;

public class ExceptionResponseFilter extends OncePerRequestFilter {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass()) ;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException {
		try {
			request.setAttribute("order", "1");
			filterChain.doFilter(request, response) ;
		} catch (Exception e) {
			
			String result = null;
			if(e instanceof UserAuthException) {
				result = ResultBean.newFailedResult("user auth faillure").toString() ;
			}else{
				result = ResultBean.newFailedResult(e.getMessage()).toString() ;
			}
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			OutputStream out = response.getOutputStream() ;
			out.write(result.getBytes("UTF-8")) ;
			out.flush() ;
			out.close() ;
		}
	}
	
}
