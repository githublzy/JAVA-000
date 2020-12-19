package com.zeke.rpc.demo.provider;

import com.zeke.rpc.core.api.RpcResolver;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Class DemoResolver
 * @Description DemoResolver
 * @Author zeke
 * @Date 18/12/2020 3:44 下午
 * @Version 1.0.0
 **/
public class DemoResolver implements RpcResolver, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public Object resolve(String serviceClass) {
        return this.applicationContext.getBean(serviceClass);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
