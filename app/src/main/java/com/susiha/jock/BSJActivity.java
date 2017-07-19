package com.susiha.jock;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.susiha.jock.NetUtils.NetAcessImpl;
import com.susiha.jock.NetUtils.NetResultLinstener;
import com.susiha.jock.Utils.Config;
import com.susiha.jock.adapter.BSJCardAdapter;
import com.susiha.jock.bean.BSJBaseBean;
import com.susiha.jock.bean.BSJItem;
import com.susiha.jock.bean.BaseBean;
import com.susiha.jock.event.BaseEvent;
import com.susiha.jock.widget.card.CardSlidePanel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class BSJActivity extends AppCompatActivity {

    private String TAG="BSJActivity";

    private CardSlidePanel image_slide_panel;
    private CardSlidePanel.CardSwitchListener cardSwitchListener;

    BSJBaseBean bsjBaseBean;

    int Count;
    private ArrayList<BSJItem> mData=new ArrayList<>();
    BSJCardAdapter adapter;
    SharedPreferences sharedPreferences;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        EventBus.getDefault().register(this);
        initView();
        sharedPreferences=getSharedPreferences(Config.BSJSharedPreferences,MODE_PRIVATE);
        Count=sharedPreferences.getInt(Config.BSJCount,1);
        getData();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onBaseEvent(BaseEvent event)
    {
        switch (event.getStatus())
        {
            case BaseEvent.SUCESS:
                button.setVisibility(View.GONE);
                mData=bsjBaseBean.getShowapi_res_body().getPagebean().getContentlist();
                adapter.setmData(mData);
                adapter.notifyDataSetChanged();

                break;
            case BaseEvent.FAILED:
                break;
            case BaseEvent.EXCEPTION:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void initView()
    {

        button=(Button)findViewById(R.id.request);
        button.setVisibility(View.GONE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
        image_slide_panel = (CardSlidePanel) findViewById(R.id.image_slide_panel);

        // 1. 左右滑动监听
        cardSwitchListener = new CardSlidePanel.CardSwitchListener() {

            @Override
            public void onShow(int index) {
//                Log.d("Card", "正在显示-" + dataList.get(index).userName);
            }

            @Override
            public void onCardVanish(int index, int type) {
                Log.d("Card", "正在消失-" + index + " 消失type=" + type+"mData的长度"+mData.size());
              if(index==mData.size()-1)
              {
                  button.setVisibility(View.VISIBLE);
              }

            }
        };
        image_slide_panel.setCardSwitchListener(cardSwitchListener);
        adapter=new BSJCardAdapter(mData);
        image_slide_panel.setAdapter(adapter);

    }



    private void getData()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                NetAcessImpl.getInstance().accessBSJ("29", "", Count+"", new NetResultLinstener() {
                    @Override
                    public void sucess(BaseBean bean) {
                        sharedPreferences.edit().putInt(Config.BSJCount,Count++).commit();
                        bsjBaseBean= (BSJBaseBean) bean;
                        BaseEvent event=new BaseEvent();
                        event.setStatus(BaseEvent.SUCESS);
                        EventBus.getDefault().post(event);

                    }

                    @Override
                    public void failed(String code, String msg) {
                        Log.i(TAG,"failed");
                    }

                    @Override
                    public void exception(String msg) {
                        Log.i(TAG,"exception");
                    }
                });
            }
        }).start();
    }







}
