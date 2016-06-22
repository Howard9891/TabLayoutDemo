package com.iyuba.myapplication.view.Behavior;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
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
    private int distance;
    private ObjectAnimator objectAnimator;
    private boolean isAppbarShow =true;
    private View nestScrollView;
    private ViewDragHelper dragger;

    private  View child ;
    public AppBar_Scroll_Behavor() {
    }
    public AppBar_Scroll_Behavor(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        objectAnimator = new ObjectAnimator();
        objectAnimator.setInterpolator(new AccelerateInterpolator());
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return super.layoutDependsOn(parent, child, dependency);

    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        return super.onDependentViewChanged(parent, child, dependency);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout parent, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }
    @Override
    public void onNestedPreScroll(CoordinatorLayout parent, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(parent, child, target, dx, dy, consumed);
      /*  Log.e("AppBar_Scroll_Behavor","onNestedPreScroll");
        // Log.e("AppBar_Scroll_Behavor",""+child.toString());
        Log.e("AppBar_Scroll_Behavor","child>>"+child);
        Log.e("AppBar_Scroll_Behavor","dx>>"+dx);
        Log.e("AppBar_Scroll_Behavor","dy>>"+dy);
        Log.e("visiable","visiable>>>"+child.getVisibility());
        Log.e("target","target>>>"+target);

        if (!isAppbarShow){
            child.animate().cancel();
        }

        if(dy>15&&isAppbarShow){
            isAppbarShow = false;
            objectAnimator.setDuration(2000).ofFloat(child,"translationY",0.0f,-child.getHeight()).start();
        }
        if(dy<-15&&!isAppbarShow){
            isAppbarShow = true;
            objectAnimator.setDuration(2000).ofFloat(child,"translationY",-child.getHeight(),0.0f).start();
        }*/

        Log.e("onNestedPreScroll","onNestedPreScroll");
        Log.e("onNestedPreScroll","Pre_dy"+dy);
        Log.e("onNestedPreScroll","parent.getTop()"+parent.getTop());
            if(child.getTop()>=getStatusBarHeight()){
                consumed[1]= scroll(child,dy,getStatusBarHeight(),400);
            }
        }
    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);

       /* Log.e("AppBar_Scroll_Behavor","onNestedScroll");
        Log.e("AppBar_Scroll_Behavor","dxConsumed>>"+dxConsumed);
        Log.e("AppBar_Scroll_Behavor","dyConsumed>>"+dyConsumed);
        Log.e("AppBar_Scroll_Behavor","dxUnconsumed>>"+dxUnconsumed);
        Log.e("AppBar_Scroll_Behavor","dyUnconsumed>>"+dyUnconsumed);
        Log.e("AppBar_Scroll_Behavor","onNestedScroll");*/
        // child.offsetTopAndBottom(dyUnconsumed);

    }

    @Override
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY) {
        return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
    }

    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY, boolean consumed) {
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }

    public int getStatusBarHeight(){
        int result = 0;
        int resourceId = mContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = mContext.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
    private int scroll(View child, int dy, int minOffest, int maxOffest) {
        int initOffest = child.getTop();
        Log.e("onNestedPreScroll","child.getTop()"+child.getTop());
        int delta = clamp(initOffest-dy,minOffest,maxOffest)-initOffest;
        child.offsetTopAndBottom(delta);
        return -delta;
    }
    private int clamp(int value, int min, int max) {
        if (value > max) {
            return max;
        } else if (value < min) {
            return min;
        } else {
            return value;
        }
    }



}
