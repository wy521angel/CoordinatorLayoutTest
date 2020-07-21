package com.wy521angel.coordinatorlayouttest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

public class TouchView extends View {

    private float mLastX;
    private float mLastY;

    public TouchView(Context context) {
        this(context, null);
    }

    public TouchView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TouchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:

            case MotionEvent.ACTION_UP:
                mLastX = event.getX();
                mLastY = event.getY();
                break;

            case MotionEvent.ACTION_MOVE:
                int deltaX = (int) (event.getX() - mLastX);
                int deltaY = (int) (event.getY() - mLastY);
                if (Math.abs(deltaX) > ViewConfiguration.getTouchSlop() || Math.abs(deltaY) > ViewConfiguration.getTouchSlop()) {
                    ViewCompat.offsetTopAndBottom(this, deltaY);
                    ViewCompat.offsetLeftAndRight(this, deltaX);
                }
                break;

            default:
                break;
        }
        return true;
    }
}
