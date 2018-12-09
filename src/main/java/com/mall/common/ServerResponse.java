package com.mall.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//此注解保证系列化json的时候，如果是null的对象，那么key也会消失
public class ServerResponse<T> implements Serializable {
    private int status;
    private String msg;
    private T data;

    private ServerResponse(int status) {
        this.status = status;
    }
    private ServerResponse(String msg) {
        this.msg = msg;
    }
    private ServerResponse(T data) {
        this.data = data;
    }

    private ServerResponse (int status, String msg){
        this.status = status;
        this.msg = msg;
    }
    private ServerResponse (int status, T data){
        this.status = status;
        this.data = data;
    }
    private ServerResponse (int status, String msg, T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    public int getStatus(){
        return this.status;
    }
    public String getMsg(){
        return this.msg;
    }
    public T getData(){
        return this.data;
    }

    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }
    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg , T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }

    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode());
    }

    public static <T> ServerResponse<T> createByErrorMessage(String msg){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),msg);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode , String msg){
        return new ServerResponse<T>(errorCode,msg);
    }


}
