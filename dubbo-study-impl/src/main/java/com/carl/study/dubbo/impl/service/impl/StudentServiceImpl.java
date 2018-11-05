package com.carl.study.dubbo.impl.service.impl;

import org.springframework.stereotype.Service;

import com.carl.study.dubbo.api.service.StudentService;

/**
 * @desc 
 * @author Carl
 * @create time 2018年11月4日下午3:55:51
 */
@Service
public class StudentServiceImpl implements StudentService{

	@Override
	public String sayHello(String name) {

		System.out.println("StudentServiceImpl.sayHello()");
		return "carl-"+name;
	}
}
