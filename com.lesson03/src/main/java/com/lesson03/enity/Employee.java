package com.lesson03.enity;

public class Employee {
    Long id;
    String fullName;
    String gender;
    int age;
    double salary;

    public Employee() {}
    public Employee(Long id, String fullName, String gender, int age, double salary) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
