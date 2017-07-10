package com.example.kangxin.myproject.bean;

import com.example.kangxin.myproject.okhttp.callback.IGenericsSerializator;
import com.google.gson.Gson;

/**
 * Created by JimGong on 2016/6/23.
 */
public class JsonGenericsSerializator implements IGenericsSerializator {
    Gson mGson = new Gson();
    @Override
    public <T> T transform(String response, Class<T> classOfT) {
        return mGson.fromJson(response, classOfT);
    }
}
