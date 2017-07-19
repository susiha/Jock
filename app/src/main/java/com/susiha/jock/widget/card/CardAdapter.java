package com.susiha.jock.widget.card;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.view.View;

/** 
 * description:
 * autour: 孙士海
 * date: 2017/7/17 15:38
 * update: 2017/7/17
*/

public abstract class CardAdapter {

    private final DataSetObservable mDataSetObservable = new DataSetObservable();

    /**
     * layout文件ID，调用者必须实现
     */
    public abstract int getLayoutId();

    /**
     * item数量，调用者必须实现
     */
    public abstract int getCount();

    /**
     * View与数据绑定回调，可重载
     */
    public abstract void bindView(View view, int index);


    /**
     * 可滑动区域定制
     *
     * @param view 拖动的View
     */
    public Rect obtainDraggableArea(View view) {
        return null;
    }


    public void registerDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.registerObserver(observer);
    }

    public void unregisterDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.unregisterObserver(observer);
    }

    public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
    }
}
