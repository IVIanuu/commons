package com.ivianuu.commons;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

import com.ivianuu.commons.Commons;

/**
 * The type View utils.
 */
public class ViewUtils {

    /**
     * Hit test boolean.
     *
     * @param v the v
     * @param x the x
     * @param y the y
     * @return the boolean
     */
    public static boolean hitTest(View v, int x, int y) {
        final int tx = (int) (v.getTranslationX() + 0.5f);
        final int ty = (int) (v.getTranslationY() + 0.5f);
        final int left = v.getLeft() + tx;
        final int right = v.getRight() + tx;
        final int top = v.getTop() + ty;
        final int bottom = v.getBottom() + ty;

        return (x >= left) && (x <= right) && (y >= top) && (y <= bottom);
    }

    /**
     * Gets center y.
     *
     * @param view the view
     * @return the center y
     */
    public static int getCenterY(View view) {
        return (int) (view.getY() + view.getHeight() / 2);
    }

    /**
     * Gets center x.
     *
     * @param view the view
     * @return the center x
     */
    public static int getCenterX(View view) {
        return (int) (view.getX() + view.getWidth() / 2);
    }


    /**
     * Convert dp to pixel int.
     *
     * @param dp the dp
     * @return the int
     */
    public static int convertDpToPixel(int dp) {
        DisplayMetrics metrics = Commons.getContext().getResources().getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return (int) px;
    }

    /**
     * Set margins of the view.
     *
     * @param v the view
     * @param l left margin
     * @param t top margin
     * @param r right margin
     * @param b bottom margin
     */
    public static void setMargins(View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }
}
