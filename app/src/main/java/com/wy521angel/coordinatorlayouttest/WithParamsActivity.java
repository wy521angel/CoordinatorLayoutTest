package com.wy521angel.coordinatorlayouttest;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class WithParamsActivity extends ListActivity {


    private String[] titles = {
            "enterAlwaysCollapsed",
            "exitUntilCollapsed",
            "parallax"
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
                startActivity(new Intent(WithParamsActivity.this, DemoActivity.class).putExtra("TAG", 100));
                break;
            case 1:
                startActivity(new Intent(WithParamsActivity.this, DemoActivity.class).putExtra("TAG", 110));
                break;
            case 2:
                startActivity(new Intent(WithParamsActivity.this, DemoActivity.class).putExtra("TAG", 120));
                break;
        }
    }
}