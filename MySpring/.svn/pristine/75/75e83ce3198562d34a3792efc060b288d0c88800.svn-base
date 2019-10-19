package com.zero.aop;

import javax.annotation.PostConstruct ;
import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.context.MessageSource ;
import org.springframework.context.annotation.Configuration ;
import com.zero.util.CheckUtil ;

@Configuration
public class StaticMessageSource {
	
	
	@Autowired
	private MessageSource messageSource;
	
	
	@PostConstruct
	public void init() {
//		String mess = messageSource.getMessage("message.key.hello", null, new Locale(""));
		CheckUtil.setMessageSource(messageSource);
	}
}
