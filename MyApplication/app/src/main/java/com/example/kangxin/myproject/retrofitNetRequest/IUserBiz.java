package com.example.kangxin.myproject.retrofitNetRequest;

import com.example.kangxin.myproject.bean.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kangxin on 17/7/11.
 */
public interface IUserBiz {
    @GET ("users")
    Call<List<User>>  getUsers();
}
