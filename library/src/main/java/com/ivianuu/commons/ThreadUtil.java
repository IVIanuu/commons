package com.ivianuu.commons;

import android.os.Looper;

/**
 * @author Manuel Wrage (IVIanuu)
 */
public class ThreadUtil {

    /**
     * Is main thread boolean.
     *
     * @return the boolean
     */
    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /**
     * Throw exception if on main thread.
     */
    public static void throwExceptionIfOnMainThread() {
        if (isMainThread()) throw new RuntimeException("should only be called from another thread");
    }
}
