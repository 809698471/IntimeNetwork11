package com.example.administrator.day9_12_startpage.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.example.administrator.day9_12_startpage.Adapter.RecyclerViewAdapter;
import com.example.administrator.day9_12_startpage.Beans.MyEntity;
import com.example.administrator.day9_12_startpage.Beans.VolleyUtils;
import com.example.administrator.day9_12_startpage.R;
import com.example.administrator.day9_12_startpage.ShouYeActivity;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    Context context;


    private ArrayList<MyEntity.DataBean> mList = new ArrayList<>();
    private RecyclerViewAdapter recyclerViewAdapter;
    private XRecyclerView mRecyclerView;
    private View inflate;
    private ImageView img,image1,image2,image3;
    private MyEntity myEntity;
    private List<MyEntity.DataBean> data;


    public BlankFragment(ShouYeActivity shouYeActivity) {
        this.context = shouYeActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_blank, container, false);
        initView();
        initData();
        return inflate;
    }

    private void initView() {
        mRecyclerView = (XRecyclerView) inflate.findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerViewAdapter = new RecyclerViewAdapter(mList, (ShouYeActivity) getActivity());
        mRecyclerView.setAdapter(recyclerViewAdapter);
    }

    private void initData() {
        VolleyUtils.getInstance(context).sendGet("http://mobile.hmeili.com/yunifang/mobile/goods/getall", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                myEntity = gson.fromJson(response, MyEntity.class);
                data = myEntity.getData();
                mList.addAll(data);
                recyclerViewAdapter.notifyDataSetChanged();
                if (data.size() > 0 && data != null) {
                    View headerview = LayoutInflater.from(context).inflate(R.layout.recyclerview_headeritem, null);
                    FlyBanner mFlyBanner = (FlyBanner) headerview.findViewById(R.id.mFlyBanner);

                    ArrayList<String> headeritem = new ArrayList<>();
                    String goods_img1 = data.get(0).getGoods_img();
                    String goods_img2 = data.get(1).getGoods_img();
                    String goods_img3 = data.get(2).getGoods_img();

                    headeritem.add(goods_img1);
                    headeritem.add(goods_img2);
                    headeritem.add(goods_img3);
                    mFlyBanner.setImagesUrl(headeritem);
                    mRecyclerView.addHeaderView(headerview);
                    img = (ImageView) headerview.findViewById(R.id.img1);
                    image1 = (ImageView) headerview.findViewById(R.id.img2);
                    image2 = (ImageView) headerview.findViewById(R.id.img3);
                    image3 = (ImageView) headerview.findViewById(R.id.img4);
                    String goods_img4 = data.get(3).getGoods_img();
                    Glide.with(context).load(goods_img1).into(img);
                    Glide.with(context).load(goods_img2).into(image1);
                    Glide.with(context).load(goods_img3).into(image2);
                    Glide.with(context).load(goods_img4).into(image3);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

    }


}
