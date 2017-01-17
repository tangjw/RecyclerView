package com.tjw.recycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        initData();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.Adapter adapter = new MyRecyclerAdapter(this, mDatas);

        //设置布局管理器
        mRecyclerView.setLayoutManager(layoutManager);

        //设置为初始布局(默认设置)
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        //设置Adapter 
        //mRecyclerView.setAdapter(new MyAdapter(new String[]{}));
        mRecyclerView.setAdapter(adapter);
        //设置分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            mDatas.add("Recycler" + i);
        }

    }
}
