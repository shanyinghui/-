package com.buba.stuinfomanager.aspect;

import com.buba.stuinfomanager.exception.BaseException;
import com.buba.stuinfomanager.util.WebUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class AspectLog {
    private final static Logger logger = LoggerFactory.getLogger(AspectLog.class);

    /**
     *  定义切点，所有被log注解标注的都是切点
     */
    @Pointcut("@annotation(com.buba.stuinfomanager.annotation.Log)")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("请求地址 : " + request.getRequestURL().toString());
        logger.info("HTTP METHOD : " + request.getMethod());
        // 获取真实的ip地址
        logger.info("IP : " + WebUtils.getRemoteAddr(request));
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        logger.info("参数 : " + Arrays.toString(joinPoint.getArgs()));
    }

    /**
     *  环绕通知
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("log()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            long startTime = System.currentTimeMillis();
            Object ob= proceedingJoinPoint.proceed();
            logger.info("耗时 : " + (System.currentTimeMillis() - startTime));
            return ob;
        } catch (Exception e) {
            logger.error("=====异常通知出现异常====");
            logger.error("error:",e);
            return new BaseException("后台操作异常",500);
        }
    }

    /**
     * 	无异常走此方法
     * @param joinPoint
     * @param e
     * @throws ClassNotFoundException
     */
    @AfterThrowing(pointcut="log()",throwing="e")
    public void afterThrowing(JoinPoint joinPoint,Exception e) {
        logger.error("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName(),e);
    }
}
