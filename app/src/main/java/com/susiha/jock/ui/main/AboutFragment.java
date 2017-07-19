package com.susiha.jock.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.susiha.jock.R;

/**
 * Created by 苏斯哈 on 2017/7/19.
 */

public class AboutFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.temp_layout,null);
        initUI(view);
        return view;
    }
    private void initUI(View view)
    {
        TextView text=(TextView)view.findViewById(R.id.text);
        text.setText(this.getClass().getName());
    }

}
