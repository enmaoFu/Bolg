package com.yy.bolg.exception;

/**
 * 自定义的异常类，其它无法处理异常
 * @author enmaoFu
 * @date 2016-12-22
 */
public class OtherThingsException extends Exception {
    public OtherThingsException(String message) {
        super(message);
    }
    public OtherThingsException(Exception e){
        this(e.getMessage());
    }

    public OtherThingsException(String message, Throwable cause) {
        super(message, cause);
    }
}
