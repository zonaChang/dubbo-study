package com.carl.study.dubbo.api.model;

import lombok.*;

/**
 * @Desc 学生类对象
 * @Author changez
 * @Time 2018/11/2 14:27
 */
//@ToString
//@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student{

  private int id;
  private String name;

}
