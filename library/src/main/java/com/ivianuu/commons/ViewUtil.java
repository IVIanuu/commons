/*
 * Copyright 2017 Manuel Wrage
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.ivianuu.commons;

import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Manuel Wrage (IVIanuu)
 */
public final class ViewUtil {

    private ViewUtil() {}

    /**
     * Checks if the coordinates are inside the view.
     *
     * @param v the v
     * @param x x of the point
     * @param y y of the point
     * @return inside the view
     */
    public static boolean hitTest(@NonNull View v, int x, int y) {
        final int tx = (int) (v.getTranslationX() + 0.5f);
        final int ty = (int) (v.getTranslationY() + 0.5f);
        final int left = v.getLeft() + tx;
        final int right = v.getRight() + tx;
        final int top = v.getTop() + ty;
        final int bottom = v.getBottom() + ty;

        return (x >= left) && (x <= right) && (y >= top) && (y <= bottom);
    }

    /**
     * Gets the center y of the view.
     *
     * @param view the view
     * @return the center y
     */
    public static int getCenterY(@NonNull View view) {
        return (int) (view.getY() + view.getHeight() / 2);
    }

    /**
     * Gets center x of the view.
     *
     * @param view the view
     * @return the center x
     */
    public static int getCenterX(@NonNull View view) {
        return (int) (view.getX() + view.getWidth() / 2);
    }


    /**
     * Converts dp to pixels.
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
    public static void setMargins(@NonNull View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() != null && v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }

    /**
     * Sets the visibility of a view to {@link View#VISIBLE} or {@link View#GONE}. Setting
     * the view to GONE removes it from the layout so that it no longer takes up any space.
     */
    public static void setGone(final @NonNull View view, final boolean gone) {
        if (gone) {
            view.setVisibility(View.GONE);
        } else {
            view.setVisibility(View.VISIBLE);
        }
    }

}
