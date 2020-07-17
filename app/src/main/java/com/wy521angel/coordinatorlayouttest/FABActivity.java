package com.wy521angel.coordinatorlayouttest;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class FABActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);
    }


    public void onClick(View v) {
        Snackbar.make(findViewById(R.id.contentView), "Snackbar", Snackbar.LENGTH_SHORT).show();
    }
}