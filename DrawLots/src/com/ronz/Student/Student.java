package com.ronz.Student;

public class Student implements Comparable<Student>{
    private String name;
    private String number;
    private int id;

    public Student(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Student(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        int flag = this.id - o.id;
        return flag == 0 ? 1 : flag;        // id相同也保存下来
    }
}
