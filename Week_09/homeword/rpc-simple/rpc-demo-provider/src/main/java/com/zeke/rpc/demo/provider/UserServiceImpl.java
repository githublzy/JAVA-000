package com.zeke.rpc.demo.provider;

import com.zeke.rpc.core.demo.api.User;
import com.zeke.rpc.core.demo.api.UserService;

/**
 * @Class UserServiceImpl
 * @Description UserServiceImpl
 * @Author zeke
 * @Date 18/12/2020 3:45 下午
 * @Version 1.0.0
 **/
public class UserServiceImpl implements UserService {

    @Override
    public User findById(int id) {
        return new User(id, "xptest" + System.currentTimeMillis());
    }
}
