package aspect;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import util.MyUtil;

@Aspect
public class LoggingAspect {

	Logger logger = MyUtil.logger(LoggingAspect.class.getName());

	@Around("execution(* services.*.*(..))")
	public void log(ProceedingJoinPoint joinPoint) {
		logger.info("차단 후, 원 메소드 호출 전");
		String methodName = joinPoint.getSignature().getName();
		Object [] arguments = joinPoint.getArgs();
		logger.info("메소드명: " + methodName);
		logger.info("인자 목록: " + Arrays.asList(arguments));
		try {
			joinPoint.proceed();
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
		logger.info("원 메소드 실행 후");
	}
}
