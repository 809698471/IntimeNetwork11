package com.example.administrator.day9_12_startpage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class StartpageActivity extends Activity  {

    private ViewPager main_viewpager;
    List<View> list = new ArrayList<>();
    private MyAdapter adapter;
    private View view3;
    private Button view3_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        main_viewpager = (ViewPager) findViewById(R.id.main_viewpager);
        initViews();
        adapter = new MyAdapter();
        main_viewpager.setAdapter(adapter);
        view3_btn = (Button) view3.findViewById(R.id.view3_btn);
        view3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartpageActivity.this,LoginActivity.class));
            }
        });
    }

    private void initViews() {
        View view1 = View.inflate(this, R.layout.view1, null);
        View view2 = View.inflate(this, R.layout.view2, null);
        view3 = View.inflate(this, R.layout.view3, null);

        list.add(view1);
        list.add(view2);
        list.add(view3);
    }



    private class MyAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override//清除view
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));
        }

        @Override//添加一个view到container,同时返回一个view对象
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }
    }
}
