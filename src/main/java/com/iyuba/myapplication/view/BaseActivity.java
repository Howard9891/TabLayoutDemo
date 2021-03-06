package com.iyuba.myapplication.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
/**
 * 作者：mingyu on 16-6-15 10:31
 * <p/>
 * 邮箱：Howard9891@163.com
 */
public abstract  class BaseActivity extends AppCompatActivity {
    protected  abstract  int getContentViewId();
    protected  abstract  int getFragmentContentId();
    protected  void addFragment(BaseFragment fragment){
        if(fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(getFragmentContentId(),
                    fragment,fragment.getClass().getSimpleName()).addToBackStack(fragment.getClass().getSimpleName()).
                    commitAllowingStateLoss();
        }
    }
    protected void removeFragment(){
        if(getSupportFragmentManager().getBackStackEntryCount()>1){
            getSupportFragmentManager().popBackStack();
        }else{
            finish();
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(KeyEvent.KEYCODE_BACK==keyCode){
            if(getSupportFragmentManager().getBackStackEntryCount()==1){
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
