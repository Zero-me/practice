package com.zero.servlet;

import java.io.IOException ;
import java.io.PrintWriter ;
import javax.servlet.ServletException ;
import javax.servlet.http.HttpServlet ;
import javax.servlet.http.HttpServletRequest ;
import javax.servlet.http.HttpServletResponse ;
import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;
import com.zero.entity.ResultBean ;

public class ErrorServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L ;
	
	private static final Logger logger = LoggerFactory.getLogger(ErrorServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.warn("illegel request");
		PrintWriter out = resp.getWriter();
        out.write(ResultBean.newFailedResult("illegel request").toString());
        out.flush();
        out.close();
	}
	
}
