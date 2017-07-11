package com.example.kangxin.myproject.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kangxin.myproject.BaseFragment;
import com.example.kangxin.myproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TokenAdvancedFragment extends BaseFragment {


    @Override
    protected int getDialogRes() {
        return 0;
    }

    @Override
    protected int getTitleRes() {
        return 0;
    }

    public TokenAdvancedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_token_advanced, container, false);
    }

}
