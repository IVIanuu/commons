package com.ivianuu.commons;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * @author Manuel Wrage (IVIanuu)
 */
public class Commons {

    private static Context mContext;

    /**
     * Gets context.
     *
     * @return the context
     */

    public static Context getContext() {
        if (mContext == null) throw new IllegalStateException("you have to call Commons.init() first");
        return mContext;
    }

    /**
     * Init.
     *
     * @param context the context
     */
    public static void init(@NonNull Context context) {
        mContext = context.getApplicationContext();
    }
}
