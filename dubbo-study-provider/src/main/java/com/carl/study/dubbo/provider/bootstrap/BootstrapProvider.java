package com.carl.study.dubbo.provider.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc provider 启动类
 * @Author changez
 * @Time 2018/10/31 18:06
 */
public class BootstrapProvider {

    public static void main(String[] args) throws Exception {
      System.setProperty("java.net.preferIPv4Stack", "true");
      ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo/provider.xml"});
      context.start();
      System.out.println("Provider started.");
      System.in.read(); // press any key to exit
    }

}
