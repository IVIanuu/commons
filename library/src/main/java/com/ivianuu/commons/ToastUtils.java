package com.ivianuu.commons;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.ivianuu.commons.Commons;

/**
 * The type Toast utils.
 */
public class ToastUtils {

    private static Handler sHandler = new Handler(Looper.getMainLooper());

    /**
     * Show short.
     *
     * @param text the text
     */
    public static void showShort(CharSequence text) {
        show(text, Toast.LENGTH_SHORT);
    }

    /**
     * Show short.
     *
     * @param stringRes the string res
     */
    public static void showShort(int stringRes) {
        showShort(Commons.getContext().getString(stringRes));
    }

    /**
     * Show long.
     *
     * @param text the text
     */
    public static void showLong(CharSequence text) {
        show(text, Toast.LENGTH_LONG);
    }

    /**
     * Show long.
     *
     * @param stringRes the string res
     */
    public static void showLong(int stringRes) {
        showLong(Commons.getContext().getString(stringRes));
    }

    private static void show(final CharSequence text, final int duration) {
        sHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(Commons.getContext(), text, duration);
                toast.show();
            }
        });
    }

}