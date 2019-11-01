package com.example.make_a_thon.network.response;

public final class ResponseJava<T> {

    private String message;
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
