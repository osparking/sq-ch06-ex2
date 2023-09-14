package aspect;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import util.MyUtil;

@Aspect
public class LoggingAspect {
	Logger logger = Logger.getLogger(LoggingAspect.class.getName());

	@Around("execution(* services.*.*(..))")
	public void log(ProceedingJoinPoint joinPoint) {
		try {
			logger.addHandler(MyUtil.handler);
			logger.setUseParentHandlers(false);
			logger.info("차단 후, 원 메소드 호출 전");
			joinPoint.proceed();
			logger.info("원 메소드 실행 후");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
