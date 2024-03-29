package com.zero;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner ;
import org.springframework.stereotype.Component;
import com.zero.filter.BaseSafeFilter ;
import com.zero.service.LogService ;
import com.zero.socket.server.SocketServer ;
/**
 * 工具启动时业务处理
 * @author liuyingying
 *
 */
@Component
public class ApplicationStartUp implements ApplicationRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LogService logService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("run");
		//工具启动时，可以做相应业务处理
//		new SocketServer().start();
		BaseSafeFilter.setLogService(logService);
	}

}
