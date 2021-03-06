package com.example.zz.scrollingtricks.MoreTab;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.zz.scrollingtricks.R;

import java.util.ArrayList;
import java.util.List;

public class MoreTabActivity extends AppCompatActivity {
    private Context mContext = this;
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private List<String> mList = new ArrayList<>();
    private TextView mTextView;
    private int curPosition = 0;
    private LinearLayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_tab);

        initData();

        initView();
    }

    private void initData() {
        for (int i = 0; i < 50; i++) {
            mList.add("这是第" + i + "个item");
        }
    }

    private void initView() {
        mTextView = (TextView) findViewById(R.id.tv_top);//悬浮的tab
        mRecyclerView = (RecyclerView) findViewById(R.id.lv_tabActivity);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new RecyclerViewAdapter(mContext, mList);
        mRecyclerView.setAdapter(mAdapter);


        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                curPosition = mLayoutManager.findFirstVisibleItemPosition();
                mTextView.setY(0);//初始时 tab处于悬浮状态
                if (mAdapter.getItemViewType(curPosition + 1) == RecyclerViewAdapter.TYPE_GROUP) {
                    View viewByPosition = mLayoutManager.findViewByPosition(curPosition + 1);
                    if (viewByPosition.getTop() > mTextView.getHeight()) {//判断tab悬浮时的条件
                        mTextView.setY(0);
                    } else {
                        mTextView.setY(-(-(viewByPosition.getTop()) + mTextView.getHeight()));
                    }
                }
                int j = (curPosition + 1) / 5;
                mTextView.setText("第" + j + "组");//第一个group
                mTextView.setVisibility(View.VISIBLE);
                View viewByPosition = mLayoutManager.findViewByPosition(curPosition + 1 + 5);//下一个group
                if (viewByPosition.getHeight() < mTextView.getHeight()) {

                    int i = (curPosition + 5 + 1) / 5;
                    mTextView.setText("第" + i + "组");
                }
            }
        });
    }
}
