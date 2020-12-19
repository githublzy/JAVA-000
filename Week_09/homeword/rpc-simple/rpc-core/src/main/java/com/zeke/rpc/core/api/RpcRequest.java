package com.zeke.rpc.core.api;

/**
 * @Class RpcRequest
 * @Description RpcRequest
 * @Author zeke
 * @Date 18/12/2020 3:15 下午
 * @Version 1.0.0
 **/
public class RpcRequest {

    private String serviceClass;

    private String method;

    private Object[] params;

    public String getServiceClass() {
        return serviceClass;
    }

    public void setServiceClass(String serviceClass) {
        this.serviceClass = serviceClass;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
