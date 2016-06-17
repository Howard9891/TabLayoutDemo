package com.iyuba.myapplication.view.Behavior;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.Scroller;
/**
 * 作者：mingyu on 16-6-17 16:12
 * <p/>
 * 邮箱：Howard9891@163.com
 */
public class AppBar_Scroll_Behavor extends CoordinatorLayout.Behavior{
    private int y;
    private int x;
    private Context mContext;
    private Scroller scorller;
    private int distance;
    private ObjectAnimator objectAnimator;
    public AppBar_Scroll_Behavor() {
    }
    public AppBar_Scroll_Behavor(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        scorller = new Scroller(mContext);
        objectAnimator = new ObjectAnimator();
        objectAnimator.setInterpolator(new AccelerateInterpolator());
    }
    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, View child, int layoutDirection) {
        distance = child.getHeight();
        Log.e("AppBar_Scroll_Behavor","onLayoutChild"+child.getHeight());
        return super.onLayoutChild(parent,child,layoutDirection);
    }
    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, View child, MotionEvent ev) {
        int action = ev.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                x = (int) ev.getX();
                y = (int) ev.getY();
                Log.e("AppBar_Scroll_Behavor","down");
                break;
            case MotionEvent.ACTION_MOVE:
                int dy = (int) (ev.getY() - y);
                int dx = (int)(ev.getX()-x);
                y = (int) ev.getY();
                x = (int)ev.getX();
                if(dy<0&&Math.abs(dy)>Math.abs(dx)){
                    Log.e("AppBar_Scroll_Behavor","ACTION_MOVE");
                    objectAnimator.setDuration(2000).ofFloat(child,"translationY",0.0f,-distance).start();
                }else if(dy>0){
                    objectAnimator.setDuration(2000).ofFloat(child,"translationY",-distance,0.0f).start();
                }
                Log.e("AppBar_Scroll_Behavor","move"+dy);
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return false;
    }
}
