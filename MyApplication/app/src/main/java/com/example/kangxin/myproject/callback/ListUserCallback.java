package com.example.kangxin.myproject.callback;

import com.example.kangxin.myproject.bean.User;
import com.example.kangxin.myproject.okhttp.callback.Callback;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Response;

/**
 * Created by zhy on 15/12/14.
 */
public abstract class ListUserCallback extends Callback<List<User>>
{

    @Override
    public List<User> parseNetworkResponse(Response response, int id) throws IOException
    {
        String string = response.body().string();
        List<User> user = new Gson().fromJson(string, List.class);
        return user;
    }


}
