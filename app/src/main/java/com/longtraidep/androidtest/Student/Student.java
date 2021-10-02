package com.longtraidep.androidtest.Student;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Student implements Serializable {

    @SerializedName(value = "name")
    private String name;
    @SerializedName(value = "avatar")
    private String avatar;
    @SerializedName(value = "id")
    private String id;

    public Student(String name, String avatar, String id) {
        this.name = name;
        this.avatar = avatar;
        this.id = id;
    }

    public Student(String name, String avatar) {
        this.name = name;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
