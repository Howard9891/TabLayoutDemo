package com.iyuba.myapplication.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者：mingyu on 16-6-15 10:22
 * <p/>
 * 邮箱：Howard9891@163.com
 */
public abstract class BaseFragment extends Fragment {
    protected BaseActivity mActivity;
    protected abstract  void initView(View view, Bundle saveInstanceState);
    protected  abstract  int getLayoutId();
    protected BaseActivity getHoldingActivity(){
        return mActivity;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (BaseActivity) activity;
    }

    protected void addFragment(BaseFragment fragment){
        if(fragment==null) {
            return;
        }
        getHoldingActivity().addFragment(fragment);

    }
    protected void removeFragment(){
        getHoldingActivity().removeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(),container,false);
        initView(view,savedInstanceState);
        return view;
    }
}
