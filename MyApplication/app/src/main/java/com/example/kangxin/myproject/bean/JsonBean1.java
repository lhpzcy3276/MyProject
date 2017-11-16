package com.example.kangxin.myproject.bean;

/**
 * Created by kangxin on 2017/9/27.
 */

public class JsonBean1 {
    private Integer name1;
    private int name2;
    private String name3;

    public JsonBean1(Integer name1, int name2, String name3) {
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
    }

    @Override
    public String toString() {
        return "JsonBean1{" +
                "name1=" + name1 +
                ", name2=" + name2 +
                ", name3='" + name3 + '\'' +
                '}';
    }
}
