package com.ronz.DrawTest;

import com.ronz.DrawManage.DrawManage;
import com.ronz.Student.Student;

import java.util.ArrayList;
import java.util.LinkedList;

public class DrawTest {
    public static void main(String[] args){
        ArrayList<Student> arrayList = new ArrayList<>();
        DrawManage drawManage = new DrawManage();
        Student[] students = new Student[3];

        students[0] = new Student("张三","21502152");
        students[1] = new Student("李四","24142120");
        students[2] = new Student("王五","45542211");

        arrayList.add(students[0]);
        arrayList.add(students[1]);
        arrayList.add(students[2]);
        drawManage.Draw(arrayList);
        drawManage.sortById();
        ArrayList<Student> drawResult = drawManage.getArrayList();

        for (Student each : drawResult){
            System.out.println(each);
        }

    }
}
