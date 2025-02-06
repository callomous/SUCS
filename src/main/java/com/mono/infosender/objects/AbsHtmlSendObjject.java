package com.mono.infosender.objects;

import lombok.Data;

import java.net.http.HttpClient;
@Data
public abstract class AbsHtmlSendObjject<T> {
    private HttpClient clientHttp;
    private String address;
    private T object;

    public abstract String toHtml();
}
