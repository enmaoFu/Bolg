package com.yy.bolg.exception;

/**
 * 自定义的异常类，存在相同的用户异常
 * @author enmaoFu
 * @date 2016-12-22
 * Created by Administrator on 2016/9/25.
 */
public class UserAireadyExistException extends Exception {
    public UserAireadyExistException(String s) {
        super(s);
    }

    public UserAireadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
