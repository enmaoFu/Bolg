package com.yy.bolg.service;

import com.yy.bolg.entity.BolgAdmin;
import com.yy.bolg.entity.User;

/**
 * Created by John on 2016/12/22.
 */
public interface BolgAdminService {

    void add(BolgAdmin bolgAdmin) throws Exception;

    BolgAdmin findUser(BolgAdmin bolgAdmin) throws Exception;

}
