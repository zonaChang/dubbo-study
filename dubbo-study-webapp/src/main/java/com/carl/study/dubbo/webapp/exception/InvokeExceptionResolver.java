package com.carl.study.dubbo.webapp.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carl.study.dubbo.webapp.response.JsonResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Component
@Slf4j
public class InvokeExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {

      log.error("invoke exception", e);
      ModelAndView mv = new ModelAndView(new MappingJackson2JsonView()).addAllObjects(JsonResponse.failure(-999, e.getMessage()));
      return mv;
    }
}
