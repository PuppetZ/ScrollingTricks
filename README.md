# ScrollingTricks<BR>
  仿商城等滑动至最顶端时，顶部TAB悬浮、固定<BR><BR>
## 示例
* 单一TAB顶部悬浮、固定<br>
  ![](https://github.com/PuppetZ/ScrollingTricks/blob/master/art/2.gif?raw=true)<br>
  * 实现原理：布局中有2个Tab，一个Tab一直处于顶部，另一个在ScrollView中。当滑动时，处于顶部的Tab显示，ScrollView中的隐藏；否则反之。<br>
  * 实现代码：需要重写ScrollView，添加一个滚动监听器<br>
  ```Java
  public void onScrollChanged(MyScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (topView != null) {
            if (y > topView.getHeight()) {//Y轴上滑位移大于顶部tab高度时
                floatView.setVisibility(View.VISIBLE);
            }else {
                floatView.setVisibility(View.GONE);
            }
        }
    }
    ```
    <br>
* 多组Tab顶部悬浮、固定<br>
  ![](https://github.com/PuppetZ/ScrollingTricks/blob/master/art/4.gif?raw=true)<br>
  * 实现原理：这里使用的是RecyclerView，原理同上个。<br>
  * 实现代码：RecyclerView滚动监听<br>
  ```Java
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
  ```
  <br>
  
