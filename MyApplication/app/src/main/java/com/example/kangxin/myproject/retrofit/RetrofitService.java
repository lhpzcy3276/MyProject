package com.example.kangxin.myproject.retrofit;

import com.example.kangxin.myproject.bean.Book;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by kangxin on 2017/12/25.
 */

public interface RetrofitService {
    @GET("book/search")
    Call<Book> getSearchBook(@Query("q") String name,
                             @Query("tag") String tag,
                             @Query("start") int start,
                             @Query("count") int count);
}
