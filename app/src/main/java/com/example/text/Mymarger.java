package com.example.text;

import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.GestureDetector;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class Mymarger extends RecyclerView.LayoutManager {
    //保存所有的Item的上下左右的偏移量信息
    private SparseArray<Rect> allItemFrames = new SparseArray<Rect>();
    //记录Item是否出现过屏幕且还没有回收。true表示出现过屏幕上，并且还没被回收
    private SparseBooleanArray hasAttachedItems = new SparseBooleanArray();
    int msundy = 0;
    int totalHeight = 0;

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        //如果没有item，直接返回
        if (getItemCount() <= 0) return;
        //在布局之前，将所有的子View先Detach掉，放入到Scrap缓存中
        detachAndScrapAttachedViews(recycler);

        //定义竖直方向的偏移量
        int offsetY = 0;
        for (int i = 0; i < getItemCount(); i++) {
            //这里就是从缓存里面取出
            View view = recycler.getViewForPosition(i);
            //将View加入到RecyclerView中
            addView(view);
            //对子View进行测量
            measureChildWithMargins(view, 0, 0);
            //把宽高拿到，宽高都是包含ItemDecorate的尺寸
            int width = getDecoratedMeasuredWidth(view);
            int height = getDecoratedMeasuredHeight(view);
            //最后，将View布局
            int i1 = getVerticalSpace() / height;
            layoutDecorated(view, 0, offsetY, width, offsetY + height);
            Rect rect = new Rect(0,offsetY,width,offsetY+height);
            allItemFrames.put(i,rect);
            //将竖直方向偏移量增大height
            offsetY += height;
            }
        totalHeight = Math.max(offsetY, getVerticalSpace());
    }



    @Override
    public boolean canScrollVertically() {
        return true;
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int travel = dy;

        //如果滑动到最顶部

        if (msundy + dy < 0) {
            travel = -msundy;
        } else if (msundy + dy > totalHeight - getVerticalSpace()) {//如果滑动到最底部
            travel = totalHeight - getVerticalSpace() - msundy;
        }

        //将竖直方向的偏移量+travel
        msundy += travel;

        // 平移容器内的item
        offsetChildrenVertical(-travel);

        return dy;
    }

    private int getVerticalSpace() {
        return getHeight() - getPaddingBottom() - getPaddingTop();
    }


}
