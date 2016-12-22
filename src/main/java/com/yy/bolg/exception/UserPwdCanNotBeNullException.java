package com.yy.bolg.exception;

/**
 * 自定义的异常类，密码为空异常
 * @author enmaoFu
 * @date 2016-12-22
 */
public class UserPwdCanNotBeNullException extends Exception {
    public UserPwdCanNotBeNullException(String s) {
        super(s);
    }

    public UserPwdCanNotBeNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
