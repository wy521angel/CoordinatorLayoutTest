package com.wy521angel.coordinatorlayouttest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (getIntent().getIntExtra("TAG", -1)) {
            case 2:
                startActivity(new Intent(this, WithParamsActivity.class));
                break;
            case 3:
                setContentView(R.layout.activity_with_viewpager);
                initView();
                break;
            case 100:
                setContentView(R.layout.activity_params1);
                initToolbarAndList();
                break;
            case 110:
                setContentView(R.layout.activity_params2);
                initToolbarAndList();
                break;
            case 120:
                setContentView(R.layout.activity_parallax);
                initToolbarAndList();
                break;
            case 200:
                setContentView(R.layout.activity_behavior_base);
                break;
            case 210:
                setContentView(R.layout.activity_behavior_move);
                break;
            case 220:
                setContentView(R.layout.activity_behavior_scroll);
                addTextData();
                break;
            case 230:
                setContentView(R.layout.activity_know);
                initList();
                break;
            case 240:
                setContentView(R.layout.activity_know2);
                initList();
                break;
            case 250:
                setContentView(R.layout.activity_xiami);
                break;
            default:
//                setContentView(R.layout.activity_fab);
        }
    }

    private void initToolbarAndList() {
        //使用这个设置标题是无效的
//        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingToolbarLayout);
//        collapsingToolbarLayout.setTitleEnabled(false);
//        collapsingToolbarLayout.setTitle("这是标题");

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("标题");
        toolbar.setLogo(getResources().getDrawable(R.mipmap.ic_launcher));
        setSupportActionBar(toolbar);

        addTextData();
    }

    private void addTextData() {
        TextView tv = findViewById(R.id.tv);
        for (int i = 0; i < 50; i++) {
            tv.append((i + 1) + "\n");
        }
    }

    private void initView() {
        VpAdapter adapter = new VpAdapter(getSupportFragmentManager());
        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager viewPager = findViewById(R.id.viewpager);
        tabLayout.setupWithViewPager(viewPager);
        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        List<Fragment> fragments = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        fragments.clear();
        titles.clear();
        for (int i = 0; i < 3; i++) {
            fragments.add(new BaseFragment());
            titles.add("页面" + i);
        }
        adapter.setFragments(fragments);
        adapter.setTitles(titles);
        viewPager.setAdapter(adapter);
    }

    private void initList() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,
                LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        ArrayList<String> mDatas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            String s = String.format("我是第%d个item", i);
            mDatas.add(s);
        }
        ItemAdapter mItemAdapter = new ItemAdapter(this, mDatas);
        mRecyclerView.setAdapter(mItemAdapter);
    }

}