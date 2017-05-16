package com.ivianuu.commons.helper;

import android.app.AppOpsManager;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.TextUtils;

import com.ivianuu.commons.Commons;
import com.ivianuu.commons.util.Utils;

import java.io.File;

/**
 * The type Access checker.
 */
public class AccessChecker {

    /**
     * Has overlay permission boolean.
     *
     * @return the boolean
     */
    public static boolean hasOverlayPermission() {
        if (Utils.isMarshmallow()) {
            if (!Settings.canDrawOverlays(Commons.getContext())) {
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
    public static boolean hasNotificationAccess() {
        ContentResolver contentResolver = Commons.getContext().getContentResolver();
        String enabledNotificationListeners = Settings.Secure.getString(contentResolver, "enabled_notification_listeners");
        String packageName = Commons.getContext().getPackageName();

        return !(enabledNotificationListeners == null || !enabledNotificationListeners.contains(packageName));
    }

    /**
     * Is accessibility enabled boolean.
     *
     * @param clazz    the clazz
     * @return the boolean
     */
    public static boolean isAccessibilityEnabled(Class clazz) {
        int accessibilityEnabled = 0;
        final String service = Commons.getContext().getPackageName() + "/" + clazz.getCanonicalName();
        try {
            accessibilityEnabled = Settings.Secure.getInt(
                    Commons.getContext().getApplicationContext().getContentResolver(),
                    android.provider.Settings.Secure.ACCESSIBILITY_ENABLED);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }

        TextUtils.SimpleStringSplitter mStringColonSplitter = new TextUtils.SimpleStringSplitter(':');

        if (accessibilityEnabled == 1) {
            String settingValue = Settings.Secure.getString(
                    Commons.getContext().getApplicationContext().getContentResolver(),
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
    public static boolean isDeviceAdminEnabled(Class clazz) {
        ComponentName admin = new ComponentName(Commons.getContext(), clazz);
        DevicePolicyManager dpm = (DevicePolicyManager)
                Commons.getContext().getSystemService(Context.DEVICE_POLICY_SERVICE);
        return dpm.isAdminActive(admin);
    }

    /**
     * Is battery optimized boolean.
     *
     * @return the boolean
     */
    public static boolean isBatteryOptimized() {
        if (!Utils.isMarshmallow()) return false;
        PowerManager pm = (PowerManager) Commons.getContext().getSystemService(Context.POWER_SERVICE);
        return !pm.isIgnoringBatteryOptimizations(Commons.getContext().getPackageName());
    }

    /**
     * Has package usage stats access boolean.
     *
     * @return the boolean
     */
    public static boolean hasPackageUsageStatsAccess() {
        if (!Utils.isLollipop()) return true;
        AppOpsManager appOps = (AppOpsManager) Commons.getContext()
                .getSystemService(Context.APP_OPS_SERVICE);
        int mode = appOps.checkOpNoThrow("android:get_usage_stats",
                android.os.Process.myUid(), Commons.getContext().getPackageName());
        return mode == AppOpsManager.MODE_ALLOWED;
    }

    /**
     * Has root access boolean.
     *
     * @return the boolean
     */
    public static boolean hasRootAccess() {
        boolean found = false;
        if (!found) {
            String[] places = {"/data/app/eu.chainfire.supersu-2", "/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/",
                    "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
            for (String where : places) {
                if (new File(where + "su").exists()) {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }
}
