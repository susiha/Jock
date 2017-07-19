package com.susiha.jock.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;

import com.susiha.jock.BaseActivity;
import com.susiha.jock.R;
import com.susiha.jock.ui.main.AboutFragment;
import com.susiha.jock.ui.main.FishFragment;
import com.susiha.jock.ui.main.JokeFragment;
import com.susiha.jock.ui.main.PhotosFragment;
import com.susiha.jock.ui.main.SportNewsFragment;
import com.susiha.jock.ui.main.VideoFragment;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;

import java.util.ArrayList;

import devlight.io.library.ntb.NavigationTabBar;

/** 
 * description:
 * autour: 孙士海
 * date: 2017/7/19 9:44 
 * update: 2017/7/19
*/

public class MainActivity extends BaseActivity {
    NavigationTabBar ntb_vertical;
    private JokeFragment jokeFragment;
    private PhotosFragment photoFragment;
    private VideoFragment videoFragment;
    private FishFragment  fishFragment;
    private SportNewsFragment sportNewsFragment;
    private AboutFragment aboutFragment;
    FragmentTransaction ft;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_ntb);
        initUI();
    }
    final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();

    private void initUI()
    {
        ntb_vertical=(NavigationTabBar)findViewById(R.id.ntb_vertical);
        ft=getSupportFragmentManager().beginTransaction();

        models.add(
                new NavigationTabBar.Model.Builder(
                        MaterialDrawableBuilder.with(MainActivity.this)
                                .setIcon(MaterialDrawableBuilder.IconValue.FILE_WORD_BOX)
                                .setColor(Color.BLACK)
                                .setSizePx(128)
                                .build(),
                        Color.parseColor("#ff6787"))
                        .title("笑话")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        MaterialDrawableBuilder.with(MainActivity.this)
                                .setIcon(MaterialDrawableBuilder.IconValue.IMAGE)
                                .setColor(Color.BLACK)
                                .setSizePx(128)
                                .build(),
                        Color.parseColor("#ff6787"))
                        .title("趣图")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        MaterialDrawableBuilder.with(MainActivity.this)
                                .setIcon(MaterialDrawableBuilder.IconValue.VIDEO)
                                .setColor(Color.BLACK)
                                .setSizePx(128)
                                .build(),
                        Color.parseColor("#ff6787"))
                        .title("视频")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        MaterialDrawableBuilder.with(MainActivity.this)
                                .setIcon(MaterialDrawableBuilder.IconValue.FISH)
                                .setColor(Color.BLACK)
                                .setSizePx(128)
                                .build(),
                        Color.parseColor("#ff6787"))
                        .title("喂鱼")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        MaterialDrawableBuilder.with(MainActivity.this)
                                .setIcon(MaterialDrawableBuilder.IconValue.NEWSPAPER)
                                .setColor(Color.BLACK)
                                .setSizePx(128)
                                .build(),
                        Color.parseColor("#ff6787"))
                        .title("新闻")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        MaterialDrawableBuilder.with(MainActivity.this)
                                .setIcon(MaterialDrawableBuilder.IconValue.INFORMATION_VARIANT)
                                .setColor(Color.BLACK)
                                .setSizePx(128)
                                .build(),
                        Color.parseColor("#ff6787"))
                        .title("关于")
                        .build()
        );
        ntb_vertical.setModels(models);
        ntb_vertical.setOnTabBarSelectedIndexListener(new NavigationTabBar.OnTabBarSelectedIndexListener() {
            @Override
            public void onStartTabSelected(NavigationTabBar.Model model, int index) {

            }
            @Override
            public void onEndTabSelected(NavigationTabBar.Model model, int index) {
                ft=getSupportFragmentManager().beginTransaction();
                if(jokeFragment!=null)
                {
                    ft.detach(jokeFragment);
                }
                if(photoFragment!=null)
                {
                    ft.detach(photoFragment);
                }
                if(videoFragment!=null)
                {
                    ft.detach(videoFragment);
                }
                if(fishFragment!=null)
                {
                    ft.detach(fishFragment);
                }
                if(sportNewsFragment!=null)
                {
                    ft.detach(sportNewsFragment);
                }
                if(aboutFragment!=null)
                {
                    ft.detach(aboutFragment);
                }
                switch (index)
                {
                    case 0:
                        if(jokeFragment==null)
                        {
                            jokeFragment=new JokeFragment();
                            ft.add(R.id.fragment_container,jokeFragment);
                        }else
                        {
                            ft.attach(jokeFragment);
                        }
                        break;
                    case 1:
                        if(photoFragment==null)
                        {
                            photoFragment=new PhotosFragment();
                            ft.add(R.id.fragment_container,photoFragment);
                        }else
                        {
                            ft.attach(photoFragment);
                        }
                        break;
                    case 2:
                        if(videoFragment==null)
                        {
                            videoFragment=new VideoFragment();
                            ft.add(R.id.fragment_container,videoFragment);
                        }else
                        {
                            ft.attach(videoFragment);
                        }
                        break;
                    case 3:
                        if(fishFragment==null)
                        {
                            fishFragment=new FishFragment();
                            ft.add(R.id.fragment_container,fishFragment);
                        }else
                        {
                            ft.attach(fishFragment);
                        }
                        break;
                    case 4:
                        if(sportNewsFragment==null)
                        {
                            sportNewsFragment=new SportNewsFragment();
                            ft.add(R.id.fragment_container,sportNewsFragment);
                        }else
                        {
                            ft.attach(sportNewsFragment);
                        }
                        break;
                    case 5:
                        if(aboutFragment==null)
                        {
                            aboutFragment=new AboutFragment();
                            ft.add(R.id.fragment_container,aboutFragment);
                        }else
                        {
                            ft.attach(aboutFragment);
                        }
                        break;
                }

                ft.commitAllowingStateLoss();
            }
        });
        ntb_vertical.setModelIndex(0,true);
    }
}
