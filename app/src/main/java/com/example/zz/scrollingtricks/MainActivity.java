package com.example.zz.scrollingtricks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyScrollView.ScrollViewListener {
    private MyScrollView mScrollView;
    private TextView floatView, topView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mScrollView = (MyScrollView) findViewById(R.id.scrollView);
        floatView = (TextView) findViewById(R.id.float_view);
        topView = (TextView) findViewById(R.id.top_view);

        mScrollView.setScrollViewListener(this);
    }

    @Override
    public void onScrollChanged(MyScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (topView != null) {
            if (y > topView.getHeight()) {//Y轴上滑位移大于顶部tab高度时
                floatView.setVisibility(View.VISIBLE);
            }else {
                floatView.setVisibility(View.GONE);
            }
        }
    }
}
