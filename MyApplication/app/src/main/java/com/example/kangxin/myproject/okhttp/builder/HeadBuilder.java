package com.example.kangxin.myproject.okhttp.builder;


import com.example.kangxin.myproject.okhttp.OkHttpUtils;
import com.example.kangxin.myproject.okhttp.request.OtherRequest;
import com.example.kangxin.myproject.okhttp.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
