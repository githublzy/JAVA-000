package com.zeke.rpc.demo.consumer;

import com.zeke.rpc.core.client.Rpc;
import com.zeke.rpc.core.demo.api.Order;
import com.zeke.rpc.core.demo.api.OrderService;
import com.zeke.rpc.core.demo.api.User;
import com.zeke.rpc.core.demo.api.UserService;

/**
 * @Class consumer
 * @Description consumer
 * @Author zeke
 * @Date 18/12/2020 3:34 下午
 * @Version 1.0.0
 **/
public class RpcDemoConsumerApplication {

    public static void main(String[] args) {
        UserService userService = Rpc.create(UserService.class, "http://localhost:8080/");
        User user = userService.findById(1);
        System.out.println("find user id=1 from server: " + user.getName());

        OrderService orderService = Rpc.create(OrderService.class, "http://localhost:8080/");
        Order order = orderService.findOrderById(1993118);
        System.out.println(String.format("find order name=%s, amount=%f",order.getName(),order.getAmount()));
    }
}
