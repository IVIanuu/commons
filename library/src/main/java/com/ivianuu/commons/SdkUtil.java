package com.ivianuu.commons;

import android.os.Build;

/**
 * @author Manuel Wrage (IVIanuu)
 */
public class SdkUtil {

    /**
     * Is kit kat boolean.
     *
     * @return the boolean
     */
    public static boolean isKitKat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
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
     * Is O boolean.
     *
     * @return the boolean
     */
    public static boolean isO() {
        return Build.VERSION.SDK_INT > Build.VERSION_CODES.N_MR1;
    }
}
