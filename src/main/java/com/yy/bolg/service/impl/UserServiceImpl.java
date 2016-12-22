package com.yy.bolg.service.impl;

import com.yy.bolg.dao.UserDao;
import com.yy.bolg.entity.User;
import com.yy.bolg.exception.*;
import com.yy.bolg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by John on 2016/12/22.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    /**
     * 添加用户，一般来说需要检查用户为空、用户名为空、密码为空
     */
    public void add(User user) throws UserCanNotBeNullException, UserNameCanNotBeNullException, UserPwdCanNotBeNullException, UserAireadyExistException, OtherThingsException {
        //先检查用户是否存在
        if (null == user) {
            //抛出用户为空的自定义异常
            throw new UserCanNotBeNullException("User can not be Null");
        }
        //用户名不能为空检查
        if (StringUtils.isEmpty(user.getLoginId())) {
            //抛出用户名为空的自定义异常
            throw new UserNameCanNotBeNullException("User name can not be Null");
        }
        //用户密码不能为空检查
        if (StringUtils.isEmpty(user.getPwd())) {
            //抛出用户密码为空的自定义异常
            throw new UserPwdCanNotBeNullException("User name can not be Null");
        }

        if(user.getAge() < 18){
            //抛出年龄小于18岁的自定义异常
            throw new OtherThingsException("Age less than 18 years old");
        }

        //已经存在相同用户
        if (null != userDao.findOneById(user.getLoginId())) {
            //存在相同的用户异常
            throw new UserAireadyExistException("Register User Failed，Because the  user Aiready exist");
        }
        int result = 0; //受影响的行数默认为0
        try {
            result = userDao.add(user);
        } catch (Exception e) {
            System.out.println("添加用户失败,用户已经存在");
            //其他用户添加失败异常
            throw new OtherThingsException(e);
        }
        if (result > 0)
            System.out.println("添加用户成功");
    }

    /**
     * 查找用户
     *
     * @param user 用户bean
     * @throws Exception
     */
    public User findUser(User user) {

        return userDao.findOneById(user.getLoginId());
    }

}
