package com.yy.bolg.exception;

/**
 * 自定义的异常类，用户为空异常
 * @author enmaoFu
 * @date 20106-12-22
 */
public class UserCanNotBeNullException extends Exception {
    public UserCanNotBeNullException(String message) {
        super(message);
    }

    public UserCanNotBeNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
