package com.susiha.jock.adapter;

import android.view.View;
import android.widget.TextView;

import com.susiha.jock.R;
import com.susiha.jock.bean.BSJItem;
import com.susiha.jock.widget.card.CardAdapter;
import java.util.ArrayList;

/** 
 * description:
 * autour: 孙士海
 * date: 2017/7/17 17:39 
 * update: 2017/7/17
*/

public class BSJCardAdapter extends CardAdapter {

    private ArrayList<BSJItem> mData;
    public BSJCardAdapter(ArrayList<BSJItem> data)
    {
        this.mData=data;
    }

    public void setmData(ArrayList<BSJItem> data)
    {
        this.mData=data;
        notifyDataSetChanged();
    }



    @Override
    public int getLayoutId() {
        return R.layout.card_item;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public void bindView(View view, int index) {
        Object tag = view.getTag();
        ViewHolder viewHolder;
        if (null != tag) {
            viewHolder = (ViewHolder) tag;
        } else {
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        viewHolder.bindData(mData.get(index));

    }

    class ViewHolder {

        TextView content;

        public ViewHolder(View view) {
            content = (TextView) view.findViewById(R.id.text_content);
        }

        public void bindData(BSJItem itemData) {
            content.setText(itemData.getText());
        }
    }
}
