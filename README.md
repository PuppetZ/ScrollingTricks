# ScrollingTricks<BR>
  仿商城等滑动至最顶端时，顶部TAB悬浮、固定<BR><BR>
## 示例
* 单一TAB顶部悬浮、固定<br>
  ![](https://github.com/PuppetZ/ScrollingTricks/blob/master/art/2.gif?raw=true)<br>
  *实现原理：布局中有2个Tab，一个Tab一直处于顶部，另一个在ScrollView中。当滑动时，处于顶部的Tab显示，ScrollView中的隐藏；否则反之。
  *实现代码：需要重写ScrollView，添加一个滚动监听器<br>
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

