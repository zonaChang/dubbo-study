package com.carl.study.dubbo.provider.service.impl;

import com.carl.study.dubbo.api.service.DemoService;

public class DemoServiceImpl implements DemoService {

  public String sayHello(String name) {
    return "Hello " + name;
  }
}
