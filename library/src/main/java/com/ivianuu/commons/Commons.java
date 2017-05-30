package com.ivianuu.commons;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * @author Manuel Wrage (IVIanuu)
 */
public class Commons {

    private static Context context;

    /**
     * Gets context.
     *
     * @return the context
     */

    public static Context getContext() {
        if (context == null) throw new IllegalStateException("you have to call Commons.init() first");
        return context;
    }

    /**
     * Init.
     *
     * @param context the context
     */
    public static void init(@NonNull Context context) {
        Commons.context = context.getApplicationContext();
    }
}
