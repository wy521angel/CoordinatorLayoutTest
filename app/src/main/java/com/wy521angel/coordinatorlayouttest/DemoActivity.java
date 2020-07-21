package com.wy521angel.coordinatorlayouttest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (getIntent().getIntExtra("TAG", -1)) {
            case 2:
                startActivity(new Intent(this, WithParamsActivity.class));
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

        TextView tv = findViewById(R.id.tv);
        for (int i = 0; i < 50; i++) {
            tv.append((i + 1) + "\n");
        }
    }

}