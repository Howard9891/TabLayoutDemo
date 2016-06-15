package com.iyuba.myapplication.view;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.iyuba.myapplication.R;
import android.support.v7.widget.RecyclerView;
/**
 * 作者：mingyu on 16-6-15 16:42
 * <p/>
 * 邮箱：Howard9891@163.com
 */
public class SubFragment1 extends BaseFragment{
    private RecyclerView fragment_sub1_rl;

    @Override
    protected void initView(View view, Bundle saveInstanceState) {
        fragment_sub1_rl = (RecyclerView)view.findViewById(R.id.fragment_sub1_rl);
        fragment_sub1_rl.setLayoutManager(new LinearLayoutManager(getContext()));
        //fragment_sub1_rl.setAdapter();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sub1;
    }
}
