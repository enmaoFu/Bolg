package com.yy.bolg.JsonEntity;

import java.util.Map;

/**
 * JSON返回实体基础类
 * @author enmaoFu
 * @date 2017-03-28
 */
public class BaseJson {

    private int code;

    private String mesage;

    private Map<String,Object> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
