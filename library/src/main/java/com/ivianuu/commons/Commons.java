package com.ivianuu.commons;

import android.content.Context;

/**
 * The type Commons.
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
    public static void init(Context context) {
        mContext = context.getApplicationContext();
    }
}
