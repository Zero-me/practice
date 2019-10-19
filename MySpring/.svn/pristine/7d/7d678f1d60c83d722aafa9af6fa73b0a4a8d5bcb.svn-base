package com.zero ;

import java.util.EventListener ;
import javax.servlet.Filter ;
import javax.servlet.Servlet ;
import org.springframework.boot.builder.SpringApplicationBuilder ;
import org.springframework.boot.web.servlet.FilterRegistrationBean ;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean ;
import org.springframework.boot.web.servlet.ServletRegistrationBean ;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer ;
import org.springframework.context.annotation.Bean ;
import org.springframework.context.annotation.Configuration ;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import com.zero.filter.UserAuthFilter;
import com.zero.listener.ApplicationListener ;
import com.zero.servlet.ErrorServlet ;
import com.zero.filter.ExceptionResponseFilter;
import com.zero.filter.SessionFilter ;
import com.zero.filter.ClientInfoFilter;

@Configuration
public class ApplicationConfig extends SpringBootServletInitializer {
	
	
	/**
	 * 外置tomcat时，需要注释
	 */
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
	
//	@Bean
//	public ServletContextAware serverEndpointExporter(final ApplicationContext applicationContext) {
//		return servletContext -> {
//			ServerEndpointExporter serverEndpointExporter = new ServerEndpointExporter();  
//			serverEndpointExporter.setApplicationContext( applicationContext);
//			serverEndpointExporter.afterPropertiesSet();
//		};
//	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class) ;
	}
	
	@Bean
	public FilterRegistrationBean<Filter> UserAuthFilter() {
		FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>() ;
		registrationBean.setFilter(new UserAuthFilter()) ;
		registrationBean.setName("userauthFilter") ;
		registrationBean.setOrder(3) ;
		registrationBean.addUrlPatterns("/*") ;// 设置过滤路径，/*所有路径
		return registrationBean ;
	}
	
	@Bean
	public FilterRegistrationBean<Filter> sessionFilter() {
		FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>() ;
		registrationBean.setFilter(new SessionFilter()) ;
		registrationBean.setName("sessionFilter") ;
		registrationBean.setOrder(4) ;
		registrationBean.addUrlPatterns("/*") ;// 设置过滤路径，/*所有路径
		return registrationBean ;
	}
	@Bean
	public FilterRegistrationBean<Filter> ClientInfoFilter() {
		FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>() ;
		registrationBean.setFilter(new ClientInfoFilter()) ;
		registrationBean.setName("clientInfoFilter") ;
		registrationBean.setOrder(2) ;
		registrationBean.addUrlPatterns("/*") ;// 设置过滤路径，/*所有路径
		return registrationBean ;
	}
	
	@Bean
	public FilterRegistrationBean<Filter> ExceptionResponseFilter() {
		FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>() ;
		registrationBean.setFilter(new ExceptionResponseFilter()) ;
		registrationBean.setName("exceptionResponseFilter") ;
		registrationBean.setOrder(1) ;
		registrationBean.addUrlPatterns("/*") ;// 设置过滤路径，/*所有路径
		return registrationBean ;
	}
	
	
	
	
//	@Bean
//	public ServletListenerRegistrationBean<EventListener> getServletListenerRegistrationBean(){
//		ServletListenerRegistrationBean<EventListener> bean  = new ServletListenerRegistrationBean<>();
//		bean.setListener(new ApplicationListener());
//		return bean;
//	}
	
//	@Bean
//	public ServletRegistrationBean<Servlet> getServletRegistrationBean(){
//		ServletRegistrationBean<Servlet> bean = new ServletRegistrationBean<>();
//		bean.addUrlMappings("/error");
//		bean.setServlet(new ErrorServlet());
//		bean.setName("errorServlet");
//		bean.setOrder(0);
//		return bean;
//	}
	
	
	
}
