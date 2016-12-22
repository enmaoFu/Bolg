package com.yy.bolg.service;

import com.yy.bolg.entity.BolgAdmin;
import com.yy.bolg.entity.User;

/**
 * 管理员的Service接口类，定义基本的对数据库数据操作
 * @author enamoFu
 * @date 2016-12-22
 */
public interface BolgAdminService {

    void add(BolgAdmin bolgAdmin) throws Exception;

    BolgAdmin findUser(BolgAdmin bolgAdmin) throws Exception;

}
