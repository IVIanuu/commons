/*
 * Copyright 2017 Manuel Wrage
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.ivianuu.commons;

import android.content.Context;
import android.support.annotation.NonNull;

import java.io.File;

/**
 * Security utils
 */
public final class SecurityUtil {

    private SecurityUtil() {
        // no instances
    }

    /**
     * Returns whether the device is rooted
     */
    public static boolean isRooted(@NonNull Context context) {
        String su = "su";
        String[] locations = {"/system/bin/", "/system/xbin/", "/sbin/", "/system/sd/xbin/", "/system/bin/failsafe/",
                "/data/local/xbin/", "/data/local/bin/", "/data/local/"};
        for (String location : locations) {
            if (new File(location + su).exists()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns whether the device has the xposed framework installed
     */
    public static boolean isXposedInstalled() {
        try {
            File xposedBridge = new File("/system/framework/XposedBridge.jar");
            return xposedBridge.exists();
        } catch (Exception ignored) {
            return false;
        }
    }
}
