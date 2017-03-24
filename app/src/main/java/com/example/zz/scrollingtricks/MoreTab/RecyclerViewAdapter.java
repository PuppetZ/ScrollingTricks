package com.example.zz.scrollingtricks.MoreTab;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zz.scrollingtricks.R;

import java.util.List;

/**
 * Created by zhangjing on 2017/3/23.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<String> mList;
    private LayoutInflater mLayoutInflater;
    public static final int TYPE_GROUP = 100;
    public static final int TYPE_TAB = 200;


    public RecyclerViewAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getItemViewType(int position) {
        if (position % 5 == 0) {
            return TYPE_GROUP;
        }
        return TYPE_TAB;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_GROUP) {
            view = mLayoutInflater.inflate(R.layout.item_group_lv, parent, false);
            return new ViewHolderGroup(view);
        } else if (viewType == TYPE_TAB) {
            view = mLayoutInflater.inflate(R.layout.item_listivew, parent, false);
            return new ViewHolderTab(view);
        }
        return  null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderGroup) {
            int i = position / 5;
            ((ViewHolderGroup) holder).mView.setText("第" + i + "组");
        } else if (holder instanceof ViewHolderTab) {
            ((ViewHolderTab) holder).mTextView.setText(mList.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class ViewHolderTab extends RecyclerView.ViewHolder {
        private TextView mTextView;

        public ViewHolderTab(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_item_lv);
        }
    }

    class ViewHolderGroup extends RecyclerView.ViewHolder {
        private TextView mView;

        public ViewHolderGroup(View itemView) {
            super(itemView);
            mView = (TextView) itemView.findViewById(R.id.tv_item_group);
        }
    }
}
