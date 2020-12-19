package com.zeke.rpc.core.demo.api;

/**
 * @Class User
 * @Description User
 * @Author zeke
 * @Date 18/12/2020 3:30 下午
 * @Version 1.0.0
 **/
public class User {

    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
