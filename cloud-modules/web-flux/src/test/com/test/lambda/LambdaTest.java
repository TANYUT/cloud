package com.test.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @Title LambdaTest.java
 * @Package com.test.lambda
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/13 15:49
 */
public class LambdaTest {

    @Test
    public void  lambda(){
        @Data @AllArgsConstructor class Student{
            private int id;
            private String name;
            private double height;
            private double score;
        }
        List<Student> students = new ArrayList<>();
        students.add(new Student(10001, "张三", 1.73, 88));
        students.add(new Student(10002, "李四", 1.71, 96));
        students.add(new Student(10003, "王五", 1.85, 88));
        class StudentIdComparator<S extends Student> implements Comparator<S> { // 2
            @Override
            public int compare(S s1, S s2) {
                return Double.compare(s1.getHeight(), s2.getHeight());
            }
        }

        students.sort(new StudentIdComparator<>());
        System.err.println(students);
    }
}
