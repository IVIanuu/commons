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
 */

package com.ivianuu.commons;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;

/**
 * Drawable util
 */
public final class DrawableUtil {

    private DrawableUtil() {
        // no instances
    }

    /**
     * Returns the tinted drawable
     */
    @NonNull
    public static Drawable getTintedDrawable(@NonNull Context context,
                                             @DrawableRes int drawableRes,
                                             @ColorInt int color) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableRes);
        drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        drawable.mutate();

        return drawable;
    }

    /**
     * Returns the vector drawable
     */
    @NonNull
    public static Drawable getVectorDrawable(@NonNull Context context, @DrawableRes int drawableRes) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return context.getDrawable(drawableRes);
        }

        return VectorDrawableCompat.create(context.getResources(), drawableRes, context.getTheme());
    }

    /**
     * Returns the tinted vector drawable
     */
    @NonNull
    public static Drawable getTintedVectorDrawable(@NonNull Context context,
                                                   @DrawableRes int drawableRes,
                                                   @ColorInt int color) {
        Drawable drawable = getVectorDrawable(context, drawableRes);
        drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        drawable.mutate();

        return drawable;
    }
}
