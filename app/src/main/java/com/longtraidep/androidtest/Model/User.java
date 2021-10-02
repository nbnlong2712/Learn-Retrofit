package com.longtraidep.androidtest.Model;

public class User {
    int age;
    String name;
    String email;
    boolean isDeveloper;

    public User(int age, String name, String email, boolean isDeveloper) {
        this.age = age;
        this.name = name;
        this.email = email;
        this.isDeveloper = isDeveloper;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDeveloper() {
        return isDeveloper;
    }

    public void setDeveloper(boolean developer) {
        isDeveloper = developer;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", isDeveloper=" + isDeveloper +
                '}';
    }
}
