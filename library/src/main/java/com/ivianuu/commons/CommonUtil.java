package com.ivianuu.commons;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDelegate;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.ivianuu.commons.Commons;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static com.ivianuu.commons.Commons.getContext;

/**
 * @author Manuel Wrage (IVIanuu)
 */
public class CommonUtil {

    /**
     * Is night mode boolean.
     *
     * @return the boolean
     */
    public static boolean isNightMode() {
        return AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES;
    }

    /**
     * Hide soft keyboard.
     *
     * @param activity the activity
     */
    public static void hideSoftKeyboard(@NonNull Activity activity) {
        if(activity.getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    /**
     * Show soft keyboard.
     *
     * @param view the view
     */
    public static void showSoftKeyboard(@NonNull View view) {
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
