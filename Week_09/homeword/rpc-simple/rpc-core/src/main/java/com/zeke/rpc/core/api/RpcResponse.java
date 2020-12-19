package com.zeke.rpc.core.api;

/**
 * @Class RpcResponse
 * @Description RpcResponse
 * @Author zeke
 * @Date 18/12/2020 3:16 下午
 * @Version 1.0.0
 **/
public class RpcResponse {
    private Object result;

    private boolean status;

    private Exception exception;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
