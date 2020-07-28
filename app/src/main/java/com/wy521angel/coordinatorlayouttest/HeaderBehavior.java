package com.wy521angel.coordinatorlayouttest;

import android.content.Context;

import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class HeaderBehavior extends CoordinatorLayout.Behavior<View> {

    public HeaderBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        return dependency.getId() == R.id.img_banner;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        if (dependency.getY() - child.getMeasuredHeight() > 0) {
            child.setY(dependency.getY() - child.getMeasuredHeight());
        } else {
            child.setY(0);
        }
        return true;
    }
}