package com.carl.study.dubbo.api.aop;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class LoggerAop {

  public Object loggerAroundMethod(ProceedingJoinPoint point) throws Throwable {

    Object result = point.proceed();

    RequestAttributes ra = RequestContextHolder.getRequestAttributes();
    ServletRequestAttributes sra = (ServletRequestAttributes) ra;
    HttpServletRequest request = sra.getRequest();

    String uri = request.getRequestURI();

    // 获取参数列表
    Object[] args = point.getArgs();
    String[] paramsName = ((MethodSignature) point.getSignature()).getParameterNames();

    StringBuffer logBuffer = new StringBuffer("statistics-log-aop: request-params=[");
    for (int i = 0; i < paramsName.length; i++) {
      logBuffer.append(" ").append(paramsName[i]).append(" = ").append(args[i]).append(",");
    }
    logBuffer.append("], uri=[").append(uri).append("],");


    logBuffer.append(" response-content=[");
    if (result instanceof ModelAndView) { //异常返回
      ModelAndView mv = (ModelAndView) result;
      Map<String, Object> mvValue = mv.getModel();
      logBuffer.append(mvValue).append("]");
    } else { //正常返回
      logBuffer.append(result).append("]");
    }
    log.info(logBuffer.toString());
    System.out.println("log-"+logBuffer.toString());
    return result;
  }

}
