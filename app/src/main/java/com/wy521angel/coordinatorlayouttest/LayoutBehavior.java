package com.wy521angel.coordinatorlayouttest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class LayoutBehavior extends CoordinatorLayout.Behavior<View> {

    public LayoutBehavior() {
    }

    public LayoutBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onLayoutChild(@NonNull CoordinatorLayout parent, @NonNull View child, int layoutDirection) {
        child.layout(0, 500, child.getMeasuredWidth(), 500 + child.getMeasuredHeight());
        return true;
    }
}
