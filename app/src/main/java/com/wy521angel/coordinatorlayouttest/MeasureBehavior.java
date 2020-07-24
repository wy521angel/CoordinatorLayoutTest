package com.wy521angel.coordinatorlayouttest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class MeasureBehavior extends CoordinatorLayout.Behavior<View> {

    public MeasureBehavior() {
    }

    public MeasureBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onMeasureChild(@NonNull CoordinatorLayout parent, @NonNull View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        int newHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(300, View.MeasureSpec.EXACTLY);
        int newWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(500, View.MeasureSpec.EXACTLY);
        parent.onMeasureChild(child, newWidthMeasureSpec, widthUsed, newHeightMeasureSpec, heightUsed);
        Log.i("MeasureBehavior", "onMeasureChild==========w=" + child.getMeasuredWidth() + "   h=" + child.getMeasuredHeight());
        return true;
    }
}
