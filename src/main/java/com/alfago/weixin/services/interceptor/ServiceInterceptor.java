package com.alfago.weixin.services.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Aspect
@Component
public class ServiceInterceptor {

	private final static Log log = LogFactory.getLog(ServiceInterceptor.class);

    /**
     * 这句话是方法切入点
     * 1 execution (* com.wangku.spring.service.impl..*.*(..))
     * 2 execution ： 表示执行
     * 3 第一个*号 : 表示返回值类型， *可以是任意类型
     * 4 com.spring.service.impl : 代表扫描的包
     * 5 .. : 代表其底下的子包也进行拦截  
     * 6 第二个*号 : 代表对哪个类进行拦截，*代表所有类  
     * 7 第三个*号 : 代表方法  *代表任意方法
     * 8 (..) : 代表方法的参数有无都可以
     */
	
	// 配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
	@Pointcut("execution (* com.alfago.weixin.service.persistence..*.*(..))")
	private void aspect() {
		System.out.println("============进入aspect方法==============");
	}

	// 配置环绕通知,使用在方法aspect()上注册的切入点
	@Around("aspect()")
	public Object around(JoinPoint joinPoint) {
		Object result = null;
		long start = System.currentTimeMillis();
		try {
			result = ((ProceedingJoinPoint) joinPoint).proceed();
			long end = System.currentTimeMillis();
			if (log.isInfoEnabled()) {
				log.info("around " + joinPoint + "\tUse time : "
						+ (end - start) + " ms!");// 这里顺便记录下执行速度，可以作为监控
			}
		} catch (Throwable e) {
			long end = System.currentTimeMillis();
			if (log.isInfoEnabled()) {
				log.info("around " + joinPoint + "\tUse time : "
						+ (end - start) + " ms with exception : "
						+ e.getMessage());
			}
		}
		return result;
	}

	// 前置通知等可以没有JoinPoint参数
	@Before("aspect()")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("==========执行前置通知===============");
		if (log.isInfoEnabled()) {
			log.info("before " + joinPoint);
		}
	}
	
 //   @Before("aspect() && args(name)")  
    public void doAccessCheck(String name){  
        System.out.println(name);  
        System.out.println("前置通知");  
    }  
    
	// 配置后置通知,使用在方法aspect()上注册的切入点
	@After("aspect()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("===========执行后置通知==============");
		if (log.isInfoEnabled()) {
			log.info("after " + joinPoint);
		}
	}

	// 配置后置返回通知,使用在方法aspect()上注册的切入点
	@AfterReturning(pointcut="execution (* com.alfago.weixin.service.persistence.impl..*.*(..))",returning="obj")
	public void afterReturn(JoinPoint joinPoint,Object obj) {

		System.out.println("===========执行后置返回通知==============");
		if (log.isInfoEnabled()) {
			log.info("afterReturn " + joinPoint);
			log.info("afterReturnObject " + obj);
		}
	}

	// 配置抛出异常后通知,使用在方法aspect()上注册的切入点
	@AfterThrowing(pointcut = "aspect()", throwing = "ex")
	public void afterThrow(JoinPoint joinPoint, Exception ex) {
		if (log.isInfoEnabled()) {
			log.info("afterThrow " + joinPoint + "\t" + ex.getMessage());
		}
	}
}
