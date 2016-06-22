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
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    private View mHeaderView;

    private List<String> lists;
    public NewsAdapter(List<String> lists){
        this.lists = lists;
    }

    public void setHeaderView(View headView){
        mHeaderView = headView;
        notifyItemChanged(0);
    }
    public View getHeaderView(){
            return  mHeaderView;
    }

    @Override
    public int getItemViewType(int position) {
        if(mHeaderView==null)  return  TYPE_NORMAL;
        if(position ==0 ) return  TYPE_HEADER;
        return TYPE_NORMAL;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mHeaderView != null && viewType == TYPE_HEADER) return new NewsHolder(mHeaderView);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_adapter_item,null);
        NewsHolder newsHolder = new NewsHolder(view);
        return newsHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == TYPE_HEADER) return;
        final int pos = getRealPosition(holder);
        NewsHolder newsHolder = (NewsHolder) holder;
        newsHolder.textView.setText(lists.get(pos));
    }

    private int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    @Override
    public int getItemCount() {
        return mHeaderView == null ? lists.size() : lists.size() + 1;
    }
    public  class NewsHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public NewsHolder(View itemView) {
            super(itemView);
            if(itemView == mHeaderView) return;
            textView = (TextView) itemView.findViewById(R.id.textview);
        }
    }
}
