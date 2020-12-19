package com.zeke.rpc.demo.provider;

import com.zeke.rpc.core.demo.api.Order;
import com.zeke.rpc.core.demo.api.OrderService;

/**
 * @Class OrderServiceImpl
 * @Description OrderServiceImpl
 * @Author zeke
 * @Date 18/12/2020 3:45 下午
 * @Version 1.0.0
 **/
public class OrderServiceImpl implements OrderService {
    @Override
    public Order findOrderById(int id) {
        return new Order(id, "ordertest" + System.currentTimeMillis(), 9.9f);
    }
}
