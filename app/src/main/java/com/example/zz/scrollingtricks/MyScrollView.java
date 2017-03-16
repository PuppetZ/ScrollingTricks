package com.example.zz.scrollingtricks;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by zhangjing on 2017/3/13.
 */

public class MyScrollView extends ScrollView {
    private  ScrollViewListener mScrollViewListener;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        mScrollViewListener = scrollViewListener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mScrollViewListener != null) {
            mScrollViewListener.onScrollChanged(this,l,t,oldl,oldt);
        }
    }


    /**
     * 定义一个监听器
     */
    public interface ScrollViewListener {

        void onScrollChanged(MyScrollView scrollView, int x, int y, int oldx, int oldy);

    }
}
