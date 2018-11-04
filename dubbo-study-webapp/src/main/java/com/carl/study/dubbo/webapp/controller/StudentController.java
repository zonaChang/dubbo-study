package com.carl.study.dubbo.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carl.study.dubbo.api.service.StudentService;

/**
 * @desc 
 * @author Carl
 * @create time 2018年11月4日下午5:08:35
 */
@RestController
@RequestMapping("/dubbo/api/student/")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("welcome")
	public String welcome(String stuName) {
		
		String welctomeResult = studentService.sayHello(stuName);
//		String welctomeResult = "hello - " + stuName;
		return welctomeResult;
		
	}

}
