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

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;

import java.io.File;

import static com.ivianuu.commons.Commons.getContext;

/**
 * @author Manuel Wrage (IVIanuu)
 */
public final class AccessUtil {

    private AccessUtil() {}

    /**
     * Check if we have overlay permission.
     *
     * @return the boolean
     */
    @TargetApi(Build.VERSION_CODES.M)
    public static boolean hasOverlayPermission() {
        if (SdkUtil.isMarshmallow()) {
            if (!Settings.canDrawOverlays(getContext())) {
                return false;
            }
        }

        return true;
    }

    /**
     * Has notification access boolean.
     *
     * @return the boolean
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static boolean hasNotificationAccess() {
        ContentResolver contentResolver = getContext().getContentResolver();
        String enabledNotificationListeners = Settings.Secure.getString(contentResolver, "enabled_notification_listeners");
        String packageName = getContext().getPackageName();

        return !(enabledNotificationListeners == null || !enabledNotificationListeners.contains(packageName));
    }

    /**
     * Is accessibility enabled boolean.
     *
     * @param clazz    the clazz
     * @return the boolean
     */
    public static boolean isAccessibilityEnabled(@NonNull Class clazz) {
        int accessibilityEnabled = 0;
        final String service = getContext().getPackageName() + "/" + clazz.getCanonicalName();
        try {
            accessibilityEnabled = Settings.Secure.getInt(
                    getContext().getApplicationContext().getContentResolver(),
                    android.provider.Settings.Secure.ACCESSIBILITY_ENABLED);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }

        TextUtils.SimpleStringSplitter mStringColonSplitter = new TextUtils.SimpleStringSplitter(':');

        if (accessibilityEnabled == 1) {
            String settingValue = Settings.Secure.getString(
                    getContext().getApplicationContext().getContentResolver(),
                    Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
            if (settingValue != null) {
                mStringColonSplitter.setString(settingValue);
                while (mStringColonSplitter.hasNext()) {
                    String accessibilityService = mStringColonSplitter.next();
                    if (accessibilityService.equalsIgnoreCase(service)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Is device admin enabled boolean.
     *
     * @param clazz the clazz
     * @return the boolean
     */
    public static boolean isDeviceAdminEnabled(@NonNull Class clazz) {
        ComponentName admin = new ComponentName(getContext(), clazz);
        DevicePolicyManager dpm = (DevicePolicyManager)
                getContext().getSystemService(Context.DEVICE_POLICY_SERVICE);
        return dpm.isAdminActive(admin);
    }

    /**
     * Is battery optimized boolean.
     */
    @TargetApi(Build.VERSION_CODES.M)
    public static boolean isBatteryOptimized() {
        if (!SdkUtil.isMarshmallow()) return false;
        PowerManager pm = (PowerManager) getContext().getSystemService(Context.POWER_SERVICE);
        return !pm.isIgnoringBatteryOptimizations(getContext().getPackageName());
    }

    /**
     * Has package usage stats access boolean.
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static boolean hasPackageUsageStatsAccess() {
        if (!SdkUtil.isLollipop()) return true;
        AppOpsManager appOps = (AppOpsManager) getContext()
                .getSystemService(Context.APP_OPS_SERVICE);
        int mode = appOps.checkOpNoThrow("android:get_usage_stats",
                android.os.Process.myUid(), getContext().getPackageName());
        return mode == AppOpsManager.MODE_ALLOWED;
    }

    /**
     * Has root access boolean.
     */
    public static boolean hasRootAccess() {
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
     * Check's if the permission is granted
     */
    public static boolean hasPermission(@NonNull String permission) {
        return (!SdkUtil.isMarshmallow()
                || ActivityCompat.checkSelfPermission(getContext(), permission) == PackageManager.PERMISSION_GRANTED);
    }
}
