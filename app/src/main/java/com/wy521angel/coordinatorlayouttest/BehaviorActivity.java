package com.wy521angel.coordinatorlayouttest;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class BehaviorActivity extends ListActivity {


    private String[] titles = {
            "Layout",
            "Move",
            "Scroll"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(BehaviorActivity.this, DemoActivity.class).putExtra("TAG", 200));
                break;
            case 1:
                startActivity(new Intent(BehaviorActivity.this, DemoActivity.class).putExtra("TAG", 210));
                break;
            case 2:
                startActivity(new Intent(BehaviorActivity.this, DemoActivity.class).putExtra("TAG", 220));
                break;
        }
    }
}