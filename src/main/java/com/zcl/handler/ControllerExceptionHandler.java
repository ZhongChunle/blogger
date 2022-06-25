package com.zcl.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 项目名称：blogger
 * 描述：自定义异常捕获错误拦截控制器
 * @ControllerAdvice 拦截所有标注有@Controller的控制器
 * @author zhong
 * @date 2022-06-24 21:29
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    /**
     * 控制台输出错误信息
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 控制返回的页面和后台的输出信息
     * @ExceptionHandler 标识这个方法可以作为异常处理的
     * @param request 获取到访问的路径url
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception e) throws Exception {
        // 控制台打印错误信息
        logger.error("Request URL:{},Exception:{}",request.getRequestURL(),e);
        // 判断是否设置的状态错误信息
        if(AnnotationUtils.findAnnotation(e.getClass(),ResponseStatus.class) != null){
            throw e;
        }
        // 创建返回的对象
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url",request.getRequestURL());
        modelAndView.addObject("exception",e);
        // 创建返回的指定页面
        modelAndView.setViewName("error/error");
        return modelAndView;
    }
}
