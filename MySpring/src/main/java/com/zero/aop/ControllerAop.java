package com.zero.aop ;

import org.aspectj.lang.ProceedingJoinPoint ;
import org.aspectj.lang.annotation.Around ;
import org.aspectj.lang.annotation.Aspect ;
import org.aspectj.lang.annotation.Pointcut ;
import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;
import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Component ;
import com.zero.entity.ResultBean ;
import com.zero.manager.OperationLogWrite ;

@Aspect
@Component
public class ControllerAop {
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass()) ;
	
	@Autowired
	private OperationLogWrite logWrite;
	
	@Pointcut("execution(public * com.zero.controller.*.*(..))")
	public void writerLog() {}
	
	
	@Around("writerLog()")
	public Object deAround(ProceedingJoinPoint pjp) {
		Object result = null ;
		String operation = pjp.getSignature().getName();
		try {
			result = pjp.proceed() ;
			if((result instanceof ResultBean)) {
				if(((ResultBean)result).getResultCode().equals("0")) {
					operation += " success";
				}else {
					operation += " failed";
				}
			}else {
				operation += " success";
			}
			
		} catch (Throwable e) {
			operation += " failed";
			logger.error("excute method [" + pjp.getSignature().getName() + "] failed") ;
			return ResultBean.newFailedResult(e.getMessage()) ;
		}finally {
			logWrite.writeLog(operation);
		}
		return result ;
	}
	
}
