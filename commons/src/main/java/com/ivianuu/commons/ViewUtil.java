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

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Px;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * View utils
 */
public final class ViewUtil {

    private ViewUtil() {
        // no instances
    }

    /**
     * Converts dp to pixels
     */
    @Px
    public static int convertDpToPx(@NonNull Context context, float dp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return (int) (dp * metrics.density);
    }

    /**
     * Converts px to dp
     */
    public static int convertPxToDp(@NonNull Context context, float px) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return (int) (px / metrics.density);
    }

    /**
     * Sets the view whether visible or gone
     */
    public static void setGone(@NonNull View view, boolean gone) {
        view.setVisibility(gone ? View.GONE : View.VISIBLE);
    }

    /**
     * Sets the view whether visible or invisible
     */
    public static void setInvisible(@NonNull View view, boolean invisible) {
        view.setVisibility(invisible ? View.INVISIBLE : View.VISIBLE);
    }
}
