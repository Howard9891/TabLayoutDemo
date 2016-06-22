package com.iyuba.myapplication.view;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import com.iyuba.myapplication.R;
import com.iyuba.myapplication.model.DataUtils;
import com.iyuba.myapplication.view.adapter.NewsAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
/**
 * 作者：mingyu on 16-6-15 16:42
 * <p/>
 * 邮箱：Howard9891@163.com
 */
public class SubFragment1 extends BaseFragment{
    private RecyclerView fragment_sub1_rl;
    private NestedScrollView nestedScrollView;
    private NestedScrollView nestedScrollView1;
    private NewsAdapter mAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void initView(View view, Bundle saveInstanceState) {
        fragment_sub1_rl = (RecyclerView)view.findViewById(R.id.fragment_sub1_rl);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        mAdapter = new NewsAdapter(DataUtils.getDatas());
        fragment_sub1_rl.setLayoutManager(new LinearLayoutManager(getContext()));
        fragment_sub1_rl.setAdapter(mAdapter);
        setHeader(fragment_sub1_rl);
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sub1;
    }
    private void setHeader(RecyclerView view) {
        View header = LayoutInflater.from(getContext()).inflate(R.layout.header, view, false);
        mAdapter.setHeaderView(header);
    }

}
