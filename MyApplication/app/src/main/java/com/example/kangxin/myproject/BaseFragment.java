package com.example.kangxin.myproject;


import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import butterknife.OnClick;
import rx.Subscription;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {
    protected Subscription subscription;

    @OnClick(R.id.tipBt)
    void tip(){
        new AlertDialog.Builder(getActivity())
                .setTitle(getTitleRes())
                .setView(getActivity().getLayoutInflater().inflate(getDialogRes(),null))
                .show();
    }

    protected abstract int getDialogRes();

    protected abstract int getTitleRes();

    public BaseFragment() {
        // Required empty public constructor
    }
    protected void unsubscribe(){
        if (subscription!=null&&!subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unsubscribe();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base, container, false);
    }

}
