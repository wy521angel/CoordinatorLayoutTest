package com.wy521angel.coordinatorlayouttest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class SearchBarBehavior extends CoordinatorLayout.Behavior<View> {

    private int searchBarHeight = 0;
    private Context context;

    public SearchBarBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        return dependency.getId() == R.id.img_header;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        float progress = dependency.getY() / getSearchBarHeight();
        child.setAlpha(progress * progress);
        return true;
    }

    private int getSearchBarHeight() {
        if (searchBarHeight == 0) {
            searchBarHeight = DisplayUtils.dp2px(context, 45);
        }
        return searchBarHeight;
    }
}