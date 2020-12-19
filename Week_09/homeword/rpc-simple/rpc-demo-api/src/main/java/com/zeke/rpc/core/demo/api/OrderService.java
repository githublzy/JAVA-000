package com.zeke.rpc.core.demo.api;

/**
 * @Class OrderService
 * @Description OrderService
 * @Author zeke
 * @Date 18/12/2020 3:31 下午
 * @Version 1.0.0
 **/
public interface OrderService {
    Order findOrderById(int id);
}
