package com.aldominium.marvelheroes.Models;

/**
 * Created by aldo on 30/12/2016.
 */

public class Basic<T> {

    private String status;
    private int code;
    private T data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }



}
