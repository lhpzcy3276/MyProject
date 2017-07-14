package com.example.kangxin.myproject.callback;

import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/**
 * Created by kangxin on 17/7/14.
 */
public class LoggingListener<A,B> implements RequestListener<A,B> {
    @Override
    public boolean onException(Exception e, A model, Target<B> target, boolean isFirstResource) {
        return false;
    }

    @Override
    public boolean onResourceReady(B resource, A model, Target<B> target, boolean isFromMemoryCache, boolean isFirstResource) {
        return false;
    }
}
