package com.ivianuu.commons;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.ivianuu.commons.Commons;

import static com.ivianuu.commons.Commons.getContext;

/**
 * The type Screen utils.
 */
public class ScreenUtils {

    public static boolean isPortrait() {
        return !isLandscape();
    }

    /**
     * Is landscape boolean.
     *
     * @return the boolean
     */
    public static boolean isLandscape() {
        return getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    /**
     * Gets rotation.
     *
     * @return the rotation
     */
    public static int getRotation(Context context) {
        WindowManager windowManager =
                (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return windowManager.getDefaultDisplay().getRotation();
    }

    /**
     * Gets screen width.
     *
     * @return the screen width
     */
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    /**
     * Gets screen height.
     *
     * @return the screen height
     */
    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static boolean hasNavBar () {
        int id = getContext().getResources().getIdentifier("config_showNavigationBar", "bool", "android");
        return id > 0 && getContext().getResources().getBoolean(id);
    }

}
