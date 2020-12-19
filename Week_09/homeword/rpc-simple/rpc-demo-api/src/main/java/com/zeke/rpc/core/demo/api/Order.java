package com.zeke.rpc.core.demo.api;

/**
 * @Class Order
 * @Description Order
 * @Author zeke
 * @Date 18/12/2020 3:30 下午
 * @Version 1.0.0
 **/
public class Order {

    private int id;

    private String name;

    private float amount;

    public Order(int id, String name, float amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
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

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
