package com.iyuba.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.iyuba.myapplication.R;

/**
 * 作者：mingyu on 16-6-15 11:38
 * <p/>
 * 邮箱：Howard9891@163.com
 */
public abstract class AppActivity extends BaseActivity{
    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }
    @Override
    protected int getFragmentContentId() {
        return R.id.fragment_container;
    }
    protected  abstract BaseFragment getFirstFragment();
    protected  abstract  void findViewById();
    protected  abstract  void initData();
    protected void handlerIntent(Intent intent){
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        findViewById();
        initData();
        if(getIntent()!=null){
            handlerIntent(getIntent());
        }
        if(getSupportFragmentManager().getFragments()==null){
            BaseFragment firstFragment = getFirstFragment();
            if(firstFragment!=null){
                addFragment(firstFragment);
            }
        }
    }
}
