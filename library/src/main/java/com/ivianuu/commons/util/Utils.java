package com.ivianuu.commons.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.v7.app.AppCompatDelegate;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.ivianuu.commons.Commons;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static com.ivianuu.commons.Commons.getContext;

/**
 * The type Utils.
 */
public class Utils {

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
     * Is night mode boolean.
     *
     * @return the boolean
     */
    public static boolean isNightMode() {
        return AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES;
    }

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

    /**
     * Hide soft keyboard.
     *
     * @param activity the activity
     */
    public static void hideSoftKeyboard(Activity activity) {
        if(activity.getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    /**
     * Show soft keyboard.
     *
     * @param view the view
     */
    public static void showSoftKeyboard(View view) {
        InputMethodManager inputMethodManager
                = (InputMethodManager) getContext().getSystemService(INPUT_METHOD_SERVICE);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, 0);
    }

    public static int resolveColor(@AttrRes int attr) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(new int[]{attr});
        try {
            return a.getColor(0, 0);
        } finally {
            a.recycle();
        }
    }

}
