package com.mapleslong.gankio.network;

/**
 * Created by Mapleslong on 16/6/10.
 */
public interface ApiCallback<T> {

    void onSuccess(T model);

    void onFailure(int code, String msg);

    void onCompleted();

}
