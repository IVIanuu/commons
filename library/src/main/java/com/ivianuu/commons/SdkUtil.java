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
 * @author Manuel Wrage (IVIanuu)
 */
public final class SdkUtil {

    private SdkUtil() {}

    /**
     * Is ice cream boolean.
     *
     * @return the boolean
     */
    public static boolean isIceCream() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
    }

    /**
     * Is ice cream mr1 boolean.
     *
     * @return the boolean
     */
    public static boolean isIceCreamMr1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1;
    }

    /**
     * Is jelly bean boolean.
     *
     * @return the boolean
     */
    public static boolean isJellyBean() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }

    /**
     * Is jelly bean mr1 boolean.
     *
     * @return the boolean
     */
    public static boolean isJellyBeanMr1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1;
    }

    /**
     * Is jelly bean mr2 boolean.
     *
     * @return the boolean
     */
    public static boolean isJellyBeanMr2() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2;
    }

    /**
     * Is kit kat boolean.
     *
     * @return the boolean
     */
    public static boolean isKitKat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    /**
     * Is kit kat watch boolean.
     *
     * @return the boolean
     */
    public static boolean isKitKatWatch() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH;
    }

    /**
     * Is lollipop boolean.
     *
     * @return the boolean
     */
    public static boolean isLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    /**
     * Is lollipop mr1 boolean.
     *
     * @return the boolean
     */
    public static boolean isLollipopMr1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1;
    }

    /**
     * Is marshmallow boolean.
     *
     * @return the boolean
     */
    public static boolean isMarshmallow() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    /**
     * Is nougat boolean.
     *
     * @return the boolean
     */
    public static boolean isNougat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N;
    }

    /**
     * Is nougat mr1 boolean.
     *
     * @return the boolean
     */
    public static boolean isNougatMr1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1;
    }

    /**
     * Is O boolean.
     *
     * @return the boolean
     */
    public static boolean isO() {
        return Build.VERSION.SDK_INT > Build.VERSION_CODES.N_MR1;
    }
}
