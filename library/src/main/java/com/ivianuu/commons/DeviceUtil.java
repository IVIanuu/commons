package com.ivianuu.commons;

import android.content.res.Configuration;

import static com.ivianuu.commons.Commons.getContext;

/**
 * @author Manuel Wrage (IVIanuu)
 */
public class DeviceUtil {

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

    public static boolean hasNavBar () {
        int id = getContext().getResources().getIdentifier("config_showNavigationBar", "bool", "android");
        return id > 0 && getContext().getResources().getBoolean(id);
    }
}
