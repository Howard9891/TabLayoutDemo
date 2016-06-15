package com.iyuba.myapplication.view;

import android.os.Bundle;
import android.view.View;

/**
 * 作者：mingyu on 16-6-15 16:20
 * <p/>
 * 邮箱：Howard9891@163.com
 */
public class SubFragment extends BaseFragment{
    public SubFragment(){
    }
    public static SubFragment newInstance(int position){
        if(position==0){

        }
        SubFragment subFragment = new SubFragment();
        return  subFragment;
    }
    @Override
    protected void initView(View view, Bundle saveInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }
}
