package com.example.kangxin.myproject.fragment;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kangxin.myproject.BaseFragment;
import com.example.kangxin.myproject.R;
import com.example.kangxin.myproject.adapter.ZhuangbiListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ElementtaryFragment extends BaseFragment {
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.gridRv)
    RecyclerView gridRv;

    ZhuangbiListAdapter adapter = new ZhuangbiListAdapter();
    @Override
    protected int getDialogRes() {
        return 0;
    }

    @Override
    protected int getTitleRes() {
        return 0;
    }

    public ElementtaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ButterKnife.bind(getActivity());

        gridRv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        gridRv.setAdapter(adapter);
        swipeRefreshLayout.setColorSchemeColors(Color.BLUE,Color.GREEN,Color.RED,Color.YELLOW);
        swipeRefreshLayout.setEnabled(false);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_elementtary, container, false);
    }

}
