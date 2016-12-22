package com.yy.bolg.dao;

import com.yy.bolg.entity.BolgAdmin;

import java.io.Serializable;
import java.util.List;

/**
 * 管理员Dao层
 * @author enmaoFu
 * @date 2016-12-22
 */
public interface BolgAdminDao extends BaseDao<BolgAdmin> {

    int add(BolgAdmin bolgAdmin);

    int del(BolgAdmin bolgAdmin);

    int update(BolgAdmin bolgAdmin);

    BolgAdmin findOneById(Serializable Id);

    List<BolgAdmin> findAll();
}
