package com.yy.bolg.service;

import com.yy.bolg.entity.User;

/**
 * Created by John on 2016/12/22.
 */
public interface UserService {

    void add(User user) throws Exception;

    User findUser(User user) throws Exception;

}
