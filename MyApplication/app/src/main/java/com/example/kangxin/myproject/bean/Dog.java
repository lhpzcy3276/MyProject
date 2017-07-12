package com.example.kangxin.myproject.bean;

import io.realm.RealmObject;

/**
 * Created by kangxin on 17/7/12.
 */
public class Dog extends RealmObject {
    private String name;
    private int age;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
