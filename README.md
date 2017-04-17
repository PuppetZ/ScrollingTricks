# ScrollingTricks<BR>
  仿商城等滑动至最顶端时，顶部TAB悬浮、固定<BR><BR>
## 示例
* 单一TAB顶部悬浮、固定<br>
  ![](https://github.com/PuppetZ/ScrollingTricks/blob/master/art/2.gif?raw=true)<br>
<br>
<br>
   布局：<br>
   ```Java
   <?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <com.example.zz.scrollingtricks.MyScrollView
        android:id="@+id/scrollView"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <TextView
                android:id="@+id/top_view"
                android:layout_width="match_parent"
                android:layout_height="150dp"
                android:background="@color/colorYellow"
                android:gravity="center"
                android:text="@string/top_tab"/>
        </LinearLayout>
    </com.example.zz.scrollingtricks.MyScrollView>

    <TextView
        android:id="@+id/float_view"
        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:background="@color/colorAccent"
        android:gravity="center"
        android:visibility="gone"
        android:text="@string/float_tab"/>

</RelativeLayout>
```
   具体实现方法：需要重新写`ScrollView`<br>
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
  当ScrollView的Y轴滑动距离大于处于顶部TAB的高度时，顶部的TAB显示出来，否则消失。
