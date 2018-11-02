package com.carl.study.jdk8.test;

import com.carl.study.dubbo.api.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Desc 测试map流的return作用
 * @Author changez
 * @Time 2018/11/2 11:31
 */
@Slf4j
public class MapStreamReturn {

  @Test
  public void mapStreamReturn(){

  }

  @Test
  public void sortSet(){

    Collection<Student> coll1 = new ArrayList<>();
    Collection<Student> coll2 = new ArrayList<>();
    Student stu1 = new Student(1, "name1");
    Student stu11 = new Student(1, "name1");
    coll1.add(stu1);
    coll1.add(stu11);

    Student stu2 = new Student(2, "name2");
    Student stu3 = new Student(3, "name3");
    Student stu4 = new Student(4, "namex4");
    Student stu5 = new Student(5, "namet5");
    coll2.add(stu2);
    coll2.add(stu3);
    coll2.add(stu4);
    coll2.add(stu5);

    Collection<Student> students = new HashSet<>();
    students.addAll(coll1);
    students.addAll(coll2);

    System.out.println("size="+students.size());
    System.out.println(students);

    Object result = students.stream().sorted(Comparator.comparing(Student::getId).reversed()).skip(1).limit(2).collect(Collectors.toList());
    System.out.println("sort:"+result);
  }
}
