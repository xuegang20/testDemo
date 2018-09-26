package com.demospringboot.utils;

/**
 * @Description TODO
 * @Author xg
 * @Date 2018/9/15 14:04
 */
public class ResultModel<T extends Object> {

    private boolean pass;
    private String message;
    private T entity;

    public ResultModel() {
        this(true, "成功");
    }

    public ResultModel(boolean pass, String message) {
        this.pass = pass;
        this.message = message;
    }

    public ResultModel(boolean pass, String message, T entity) {
        this.pass = pass;
        this.message = message;
        this.entity = entity;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}
