package com.carl.study.dubbo.consumer.bootstrap;

import com.carl.study.dubbo.api.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * @Desc dubbo 消费者启动类
 * @Author changez
 * @Time 2018/10/31 18:15
 */
public class BootstrapConsumer {

    public static void main(String[] args) throws Exception {
      ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"dubbo/consumer.xml"});
      context.start();
      // Obtaining a remote service proxy
      DemoService demoService = (DemoService)context.getBean("demoService");
      // Executing remote methods
      String hello = demoService.sayHello("world");
      // Display the call result
      System.out.println(hello);
      int a = 0;
    }
}
