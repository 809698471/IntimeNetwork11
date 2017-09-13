package com.example.administrator.day9_12_startpage;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.administrator.day9_12_startpage.Adapter.ViewPagerAdapter;
import com.example.administrator.day9_12_startpage.Fragment.BlankFragment;
import com.example.administrator.day9_12_startpage.Fragment.BlankFragment2;
import com.example.administrator.day9_12_startpage.Fragment.BlankFragment3;

import java.util.ArrayList;

public class ShouYeActivity extends AppCompatActivity {

    private Toolbar tb_toolbar;
    private ViewPager view_pager;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shou_ye);
        setTitle("");
        initView();

        initData();
    }


    private void initView() {
///////
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        tab = (TabLayout) findViewById(R.id.tab);

    }

    private void initData() {
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new BlankFragment(ShouYeActivity.this));
        list.add(new BlankFragment2());
        list.add(new BlankFragment3());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("首页");
        strings.add("购物车");
        strings.add("地图");
        ViewPagerAdapter vp = new ViewPagerAdapter(list,strings,ShouYeActivity.this.getSupportFragmentManager());
        view_pager.setAdapter(vp);
       tab.setupWithViewPager(view_pager);

    }
}
