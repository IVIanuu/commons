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

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.support.annotation.Dimension;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Px;

/**
 * Attributes util
 */
public final class AttrUtil {

    private AttrUtil() {
        // no instances
    }

    /**
     * Returns the attributes boolean
     */
    public static boolean resolveBoolean(@NonNull Context context, @AttrRes int attr) {
        return resolveBoolean(context, attr, false);
    }

    /**
     * Returns the attributes boolean
     */
    public static boolean resolveBoolean(@NonNull Context context, @AttrRes int attr, boolean defaultValue) {
        TypedArray array = getTypedArrayWithAttributes(context, attr);
        boolean bool = array.getBoolean(0, defaultValue);
        array.recycle();
        return bool;
    }

    /**
     * Returns the attributes color
     */
    @ColorInt
    public static int resolveColor(@NonNull Context context, @AttrRes int attr) {
        return resolveColor(context, attr, -1);
    }

    /**
     * Returns the attributes color
     */
    @ColorInt
    public static int resolveColor(@NonNull Context context, @AttrRes int attr, @ColorInt int defaultValue) {
        TypedArray array = getTypedArrayWithAttributes(context, attr);
        int color = array.getColor(0, defaultValue);
        array.recycle();
        return color;
    }

    /**
     * Returns the attributes color state list
     */
    @Nullable
    public static ColorStateList resolveColorStateList(@NonNull Context context, @AttrRes int attr) {
        return resolveColorStateList(context, attr, null);
    }

    /**
     * Returns the attributes color state list
     */
    @Nullable
    public static ColorStateList resolveColorStateList(@NonNull Context context,
                                                       @AttrRes int attr,
                                                       @Nullable ColorStateList defaultValue) {
        TypedArray array = getTypedArrayWithAttributes(context, attr);
        ColorStateList colorStateList = array.getColorStateList(0);
        array.recycle();
        return colorStateList != null ? colorStateList : defaultValue;
    }

    /**
     * Returns the attributes dimension
     */
    @Dimension
    public static float resolveDimension(@NonNull Context context, @AttrRes int attr) {
        return resolveDimension(context, attr, -1);
    }

    /**
     * Returns the attributes dimension
     */
    @Dimension
    public static float resolveDimension(@NonNull Context context, @AttrRes int attr, @Dimension float defaultValue) {
        TypedArray array = getTypedArrayWithAttributes(context, attr);
        float dimension = array.getDimension(0, defaultValue);
        array.recycle();
        return dimension;
    }

    /**
     * Returns the attributes dimension pixel offset
     */
    @Px
    public static int resolveDimensionPixelOffset(@NonNull Context context, @AttrRes int attr) {
        return resolveDimensionPixelOffset(context, attr, -1);
    }

    /**
     * Returns the attributes dimension pixel offset
     */
    @Px
    public static int resolveDimensionPixelOffset(@NonNull Context context, @AttrRes int attr, @Px int defaultValue) {
        TypedArray array = getTypedArrayWithAttributes(context, attr);
        int dimension = array.getDimensionPixelOffset(0, defaultValue);
        array.recycle();
        return dimension;
    }

    /**
     * Returns the attributes dimension pixel size
     */
    @Px
    public static int resolveDimensionPixelSize(@NonNull Context context, @AttrRes int attr) {
        return resolveDimensionPixelSize(context, attr, -1);
    }

    /**
     * Returns the attributes dimension pixel size
     */
    @Px
    public static int resolveDimensionPixelSize(@NonNull Context context, @AttrRes int attr, @Px int defaultValue) {
        TypedArray array = getTypedArrayWithAttributes(context, attr);
        int dimension = array.getDimensionPixelSize(0, defaultValue);
        array.recycle();
        return dimension;
    }

    /**
     * Returns the attributes drawable
     */
    @Nullable
    public static Drawable resolveDrawable(@NonNull Context context, @AttrRes int attr) {
        return resolveDrawable(context, attr, null);
    }

    /**
     * Returns the attributes drawable
     */
    @Nullable
    public static Drawable resolveDrawable(@NonNull Context context, @AttrRes int attr, @Nullable Drawable defaultValue) {
        TypedArray array = getTypedArrayWithAttributes(context, attr);
        Drawable drawable = array.getDrawable(0);
        array.recycle();
        return drawable != null ? drawable : defaultValue;
    }

    /**
     * Returns the attributes float
     */
    public static float resolveFloat(@NonNull Context context, @AttrRes int attr) {
        return resolveFloat(context, attr, -1f);
    }

    /**
     * Returns the attributes float
     */
    public static float resolveFloat(@NonNull Context context, @AttrRes int attr, float defaultValue) {
        TypedArray array = getTypedArrayWithAttributes(context, attr);
        float floatValue = array.getFloat(0, defaultValue);
        array.recycle();
        return floatValue;
    }

    /**
     * Returns the attributes font
     */
    @Nullable
    public static Typeface resolveFont(@NonNull Context context, @AttrRes int attr) {
        return resolveFont(context, attr, null);
    }

    /**
     * Returns the attributes font
     */
    @TargetApi(Build.VERSION_CODES.O)
    @Nullable
    public static Typeface resolveFont(@NonNull Context context, @AttrRes int attr, @Nullable Typeface defaultValue) {
        TypedArray array = getTypedArrayWithAttributes(context, attr);
        Typeface font = array.getFont(0);
        array.recycle();
        return font != null ? font : defaultValue;
    }

    /**
     * Returns the attributes int
     */
    public static int resolveInt(@NonNull Context context, @AttrRes int attr) {
        return resolveInt(context, attr, -1);
    }

    /**
     * Returns the attributes int
     */
    public static int resolveInt(@NonNull Context context, @AttrRes int attr, int defaultValue) {
        TypedArray array = getTypedArrayWithAttributes(context, attr);
        Integer intValue = array.getInt(0, defaultValue);
        array.recycle();
        return intValue;
    }

    /**
     * Returns the attributes integer
     */
    @NonNull
    public static Integer resolveInteger(@NonNull Context context, @AttrRes int attr) {
        return resolveInteger(context, attr, -1);
    }

    /**
     * Returns the attributes integer
     */
    @NonNull
    public static Integer resolveInteger(@NonNull Context context, @AttrRes int attr, Integer defaultValue) {
        TypedArray array = getTypedArrayWithAttributes(context, attr);
        Integer integer = array.getInteger(0, defaultValue);
        array.recycle();
        return integer;
    }

    /**
     * Returns the attributes string
     */
    @Nullable
    public static String resolveString(@NonNull Context context, @AttrRes int attr) {
        return resolveString(context, attr, null);
    }

    /**
     * Returns the attributes string
     */
    @Nullable
    public static String resolveString(@NonNull Context context, @AttrRes int attr, @Nullable String defaultValue) {
        TypedArray array = getTypedArrayWithAttributes(context, attr);
        String string = array.getString(0);
        array.recycle();
        return string != null ? string : defaultValue;
    }

    /**
     * Returns the attributes text
     */
    @Nullable
    public static CharSequence resolveText(@NonNull Context context, @AttrRes int attr) {
        return resolveString(context, attr, null);
    }

    /**
     * Returns the attributes text
     */
    @Nullable
    public static CharSequence resolveText(@NonNull Context context, @AttrRes int attr, @Nullable CharSequence defaultValue) {
        TypedArray array = getTypedArrayWithAttributes(context, attr);
        CharSequence charSequence = array.getText(0);
        array.recycle();
        return charSequence != null ? charSequence : defaultValue;
    }

    /**
     * Returns the attributes text array
     */
    @Nullable
    public static CharSequence[] resolveTextArray(@NonNull Context context, @AttrRes int attr) {
        return resolveTextArray(context, attr, null);
    }

    /**
     * Returns the attributes text array
     */
    @Nullable
    public static CharSequence[] resolveTextArray(@NonNull Context context, @AttrRes int attr,
                                                  @Nullable CharSequence[] defaultValue) {
        TypedArray array = getTypedArrayWithAttributes(context, attr);
        CharSequence[] charSequence = array.getTextArray(0);
        array.recycle();
        return charSequence != null ? charSequence : defaultValue;
    }

    private static TypedArray getTypedArrayWithAttributes(Context context, int... attr) {
        return context.getTheme().obtainStyledAttributes(attr);
    }
}
