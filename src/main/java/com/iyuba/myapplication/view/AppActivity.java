package com.iyuba.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.iyuba.myapplication.R;

/**
 * 作者：mingyu on 16-6-15 11:38
 * <p/>
 * 邮箱：Howard9891@163.com
 */
public abstract class AppActivity extends BaseActivity{
    @Override
    protected int getContentViewId() {
        return R.layout.activity_base;
    }
    @Override
    protected int getFragmentContentId() {
        return R.id.fragment_container;
    }

    protected  abstract BaseFragment getFirstFragment();

    protected void handlerIntent(Intent intent){

    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(getContentViewId());
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
