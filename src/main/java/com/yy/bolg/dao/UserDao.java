package com.yy.bolg.dao;

import com.yy.bolg.entity.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by John on 2016/12/22.
 */
public interface UserDao extends BaseDao<User>{

    int add(User user);

    int del(User user);

    int update(User user);

    User findOneById(Serializable Id);

    List<User> findAll();

}
