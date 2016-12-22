package com.yy.bolg.exception;

/**
 * 自定义的异常类，用户名为空异常
 * @author enmaoFu
 * @date 2016-12-22
 */
public class UserNameCanNotBeNullException extends Exception {
    public UserNameCanNotBeNullException(String s) {
        super(s);
    }

    public UserNameCanNotBeNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
