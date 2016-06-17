package com.iyuba.myapplication.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iyuba.myapplication.R;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

/**
 * 作者：mingyu on 16-6-17 15:57
 * <p/>
 * 邮箱：Howard9891@163.com
 */
public class NewsAdapter extends RecyclerView.Adapter {

    private List<String> lists;
    public NewsAdapter(List<String> lists){
        this.lists = lists;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_adapter_item,null);
        NewsHolder newsHolder = new NewsHolder(view);
        return newsHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NewsHolder newsHolder = (NewsHolder) holder;
        newsHolder.textView.setText(lists.get(position));
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
    public static class NewsHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public NewsHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textview);
        }
    }
}
