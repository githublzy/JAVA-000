package com.zeke.rpc.demo.provider;

import com.zeke.rpc.core.api.RpcRequest;
import com.zeke.rpc.core.api.RpcResolver;
import com.zeke.rpc.core.api.RpcResponse;
import com.zeke.rpc.core.demo.api.OrderService;
import com.zeke.rpc.core.demo.api.UserService;
import com.zeke.rpc.core.server.RpcInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class RpcDemoProviderApplication
 * @Description RpcDemoProviderApplication
 * @Author zeke
 * @Date 18/12/2020 3:46 下午
 * @Version 1.0.0
 **/
@SpringBootApplication
@RestController
public class RpcDemoProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(RpcDemoProviderApplication.class, args);
    }

    @Autowired
    RpcInvoker invoker;

    @PostMapping("/")
    public RpcResponse invoke(@RequestBody RpcRequest request) {
        return invoker.invoke(request);
    }

    @Bean
    public RpcInvoker createInvoker(@Autowired RpcResolver resolver){
        return new RpcInvoker(resolver);
    }

    @Bean
    public RpcResolver createResolver(){
        return new DemoResolver();
    }

    @Bean(name = "com.zeke.rpc.demo.api.UserService")
    public UserService createUserService(){
        return new UserServiceImpl();
    }

    @Bean(name = "com.zeke.rpc.demo.api.OrderService")
    public OrderService createOrderService(){
        return new OrderServiceImpl();
    }

}
