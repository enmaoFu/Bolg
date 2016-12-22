package com.yy.bolg.service.impl;

import com.yy.bolg.dao.BolgAdminDao;
import com.yy.bolg.entity.BolgAdmin;
import com.yy.bolg.entity.User;
import com.yy.bolg.exception.*;
import com.yy.bolg.service.BolgAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by John on 2016/12/22.
 */
@Service("bolgAdminService")
public class BolgAdminServiceImpl implements BolgAdminService{

    @Autowired
    private BolgAdminDao bolgAdminDao;

    public void add(BolgAdmin bolgAdmin) throws UserCanNotBeNullException, UserNameCanNotBeNullException, UserPwdCanNotBeNullException, UserAireadyExistException, OtherThingsException {

        //先检查用户是否存在
        if (null == bolgAdmin) {
            //抛出用户为空的自定义异常
            throw new UserCanNotBeNullException("User can not be Null");
        }
        //用户名不能为空检查
        if (StringUtils.isEmpty(bolgAdmin.getId())) {
            //抛出用户名为空的自定义异常
            throw new UserNameCanNotBeNullException("User name can not be Null");
        }
        //用户密码不能为空检查
        if (StringUtils.isEmpty(bolgAdmin.getMybolg_admin_key())) {
            //抛出用户密码为空的自定义异常
            throw new UserPwdCanNotBeNullException("User name can not be Null");
        }

        //已经存在相同用户
        if (null != bolgAdminDao.findOneById(bolgAdmin.getId())) {
            //存在相同的用户异常
            throw new UserAireadyExistException("Register User Failed，Because the  user Aiready exist");
        }
        int result = 0; //受影响的行数默认为0
        try {
            result = bolgAdminDao.add(bolgAdmin);
        } catch (Exception e) {
            System.out.println("添加用户失败,用户已经存在");
            //其他用户添加失败异常
            throw new OtherThingsException(e);
        }
        if (result > 0)
            System.out.println("添加用户成功");

    }

    public BolgAdmin findUser(BolgAdmin bolgAdmin){

        return bolgAdminDao.findOneById(bolgAdmin.getId());
    }
}
