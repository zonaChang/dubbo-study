package com.carl.study.dubbo.impl.bootstrap;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc provider 启动类
 * @Author changez
 * @Time 2018/10/31 18:06
 */
public class BootstrapProvider {

    public static void main(String[] args) throws Exception {
      System.setProperty("java.net.preferIPv4Stack", "true");
      ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/*.xml", "dubbo/*.xml"});
      context.start();
      System.out.println("Provider started.");
      System.in.read(); // press any key to exit
    }

}
