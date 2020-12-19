package com.zeke.rpc.core.api;

/**
 * @Class RpcResolver
 * @Description RpcResolver
 * @Author zeke
 * @Date 18/12/2020 3:16 下午
 * @Version 1.0.0
 **/
public interface RpcResolver {
    Object resolve(String serviceClass);
}
