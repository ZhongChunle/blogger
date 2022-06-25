package com.zcl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 项目名称：blogger
 * 描述：拦截日志信息返回
 *
 * @author zhong
 * @date 2022-06-24 22:04
 */
@Aspect
@Component
public class LogAspect {
    /**
     * 控制台输出错误信息
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 在所有的web里都切一刀
     */
    @Pointcut("execution(* com.zcl.web.*.*(..))")
    public void log(){}

    /**
     * 在切面之前执行方法,获取信息输出日志
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 获取到具体的请求参数
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        logger.info("Request:{}",requestLog);
    }

    /**
     * 在切面执行之后执行的方法的
     */
    @After("log()")
    public void doAfter(){
        //logger.info("------doAfter------");
    }

    /**
     * 切面返回内容的数据
     * @param result
     */
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterRuture(Object result){
        logger.info("Result：{}",result);
    }

    /**
     * 创建内部类封装日志信息
     */
    public class RequestLog{
        private String url;
        private String ip;
        // 请求的方法
        private String classMethod;
        // 请求的参数
        private Object[] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
