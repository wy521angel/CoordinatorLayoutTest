package com.wy521angel.coordinatorlayouttest;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {


    private String[] titles = {
            "FloatingActionButton",
            "AppBarLayout",
            "CollapsingToolbarLayout",
            "ViewPager",
            "Behavior",
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
                startActivity(new Intent(MainActivity.this, FABActivity.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, AppBarActivity.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity.this, DemoActivity.class).putExtra("TAG", 2));
                break;
            case 3:
                startActivity(new Intent(MainActivity.this, DemoActivity.class).putExtra("TAG", 3));
                break;
            case 4:
                startActivity(new Intent(MainActivity.this, BehaviorActivity.class));
                break;
        }
    }
}