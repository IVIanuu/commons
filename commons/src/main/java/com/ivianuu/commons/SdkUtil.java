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

import android.os.Build;

/**
 * Sdk utils
 */
public final class SdkUtil {

    private SdkUtil() {
        // no instances
    }

    /**
     * Returns whether the device runs on ice cream mr1
     */
    public static boolean isIceCreamMr1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1;
    }

    /**
     * Returns whether the device runs on jelly bean
     */
    public static boolean isJellyBean() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }

    /**
     * Returns whether the device runs on jelly bean mr1
     */
    public static boolean isJellyBeanMr1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1;
    }

    /**
     * Returns whether the device runs on jelly bean mr2
     */
    public static boolean isJellyBeanMr2() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2;
    }

    /**
     * Returns whether the device runs on kitkat
     */
    public static boolean isKitKat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    /**
     * Returns whether the device runs on kitkat watch
     */
    public static boolean isKitKatWatch() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH;
    }

    /**
     * Returns whether the device runs on lollipop
     */
    public static boolean isLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    /**
     * Returns whether the device runs on lollipop mr1
     */
    public static boolean isLollipopMr1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1;
    }

    /**
     * Returns whether the device runs on marshmallow
     */
    public static boolean isMarshmallow() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    /**
     * Returns whether the device runs on nougat
     */
    public static boolean isNougat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N;
    }

    /**
     * Returns whether the device runs on nougat mr1
     */
    public static boolean isNougatMr1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1;
    }

    /**
     * Returns whether the device runs on oreo
     */
    public static boolean isOreo() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.O;
    }
}
