package com.example.anew.gittest;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Recyclerview_scccro extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnTest;
    private RecyclerView mRecyclerviewItem;
    private List<Costom_person> mlist = new ArrayList<>();
    private SwipeRefreshLayout re;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        for (int i = 0; i < 10; i++) {
            Costom_person c = new Costom_person();
            c.name = i + "a";
            mlist.add(c);
        }
        initView();
    }

    private void initView() {
        re = (SwipeRefreshLayout) findViewById(R.id.refrech);
        mBtnTest = (Button) findViewById(R.id.btn_test);
        mBtnTest.setOnClickListener(this);
        mRecyclerviewItem = (RecyclerView) findViewById(R.id.recyclerview_item);
        LinearLayoutManager mm = new LinearLayoutManager(Recyclerview_scccro.this);
        mm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerviewItem.setLayoutManager(mm);
        Adapter_recy rr = new Adapter_recy(mlist);
        mRecyclerviewItem.setAdapter(rr);

        re.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                threaddd();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
                Toast.makeText(this, "中国", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void threaddd() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        re.setRefreshing(false);
                        Toast.makeText(Recyclerview_scccro.this, "数据刷新成功", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }).start();


    }
}
