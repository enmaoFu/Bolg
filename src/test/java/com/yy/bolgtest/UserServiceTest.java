package com.yy.bolgtest;

import com.yy.bolg.dao.BolgAdminDao;
import com.yy.bolg.entity.BolgAdmin;
import com.yy.bolg.entity.User;
import com.yy.bolg.exception.*;
import com.yy.bolg.service.impl.BolgAdminServiceImpl;
import com.yy.bolg.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by John on 2016/12/22.
 */
public class UserServiceTest extends BaseTest {

    /**
     * 此处直接使用UserService的实现类，主要是方便抛出异常，然后异常出现时候可以针对性的处理
     */
    @Autowired
    private BolgAdminDao bolgAdminDao;

    @Test
    public void testAdd() {
        BolgAdmin bolgAdmin = new BolgAdmin();
        bolgAdmin.setId(2);
        bolgAdmin.setMybolg_admin_key("987564321");
        bolgAdminDao.add(bolgAdmin);
    }

    @Test
    public void testSelect() throws Exception {

        BolgAdmin bolgAdmin = new BolgAdmin();
        bolgAdmin.setId(1);
        bolgAdmin.setMybolg_admin_key("987");

        //查找用户
        BolgAdmin ba = bolgAdminDao.findOneById(bolgAdmin.getId());
        System.out.println(bolgAdmin.getMybolg_admin_key() + "------" + ba.getMybolg_admin_key());
        if(ba == null){
            System.out.println("未找到该用户");
        }else{
            if(!ba.getMybolg_admin_key().equals(bolgAdmin.getMybolg_admin_key())){
                System.out.println("密码错误");
            }else{
                System.out.println("密码正确");
            }
        }

    }

}