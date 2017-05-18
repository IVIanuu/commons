package com.ivianuu.commons;

import android.content.res.Configuration;

import static com.ivianuu.commons.Commons.getContext;

/**
 * Author IVIanuu.
 */

public class DeviceUtils {

    /**
     * Is tablet boolean.
     *
     * @return the boolean
     */
    public static boolean isTablet() {
        return (getContext().getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }
}
