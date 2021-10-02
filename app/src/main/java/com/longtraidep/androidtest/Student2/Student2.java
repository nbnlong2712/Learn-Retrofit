package com.longtraidep.androidtest.Student2;

public class Student2 {
    private Long id;
    private String fullname;
    private int age;
    private String address;

    ///////////////////////////

    public Student2()
    {}

    public Student2(String fullname, int age, String address) {
        this.fullname = fullname;
        this.age = age;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                "}\n";
    }
}
