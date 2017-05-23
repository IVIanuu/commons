package com.ivianuu.commons;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.PowerManager;

import com.ivianuu.commons.Commons;

import static com.ivianuu.commons.SdkUtil.isLollipop;

/**
 * @author Manuel Wrage (IVIanuu)
 */
public class PowerUtil {

    private static final int LOW_BATTERY = 15;

    /**
     * Is screen on boolean.
     *
     * @return the boolean
     */
    public static boolean isScreenOn() {
        PowerManager powerManager = (PowerManager) Commons.getContext().getSystemService(Context.POWER_SERVICE);
        if (isLollipop()) {
            return powerManager.isInteractive();
        } else {
            return powerManager.isScreenOn();
        }
    }

    /**
     * Is plugged boolean.
     *
     * @return the boolean
     */
    public static boolean isPlugged() {
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent intent = Commons.getContext().registerReceiver(null, intentFilter);
        if (intent == null) {
            return false;
        }

        final int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        return plugged == BatteryManager.BATTERY_PLUGGED_AC
                || plugged == BatteryManager.BATTERY_PLUGGED_USB
                || plugged == BatteryManager.BATTERY_PLUGGED_WIRELESS;
    }

    /**
     * Gets battery level.
     *
     * @return the battery level
     */
    public static int getBatteryLevel() {
        Intent batteryIntent = Commons.getContext().registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        if (batteryIntent == null) return 50;
        int level = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        if(level == -1 || scale == -1) {
            return 50;
        }

        return (int) (((float)level / (float)scale) * 100.0f);
    }

    /**
     * Is battery low boolean.
     *
     * @return the boolean
     */
    public static boolean isBatteryLow() {
        return getBatteryLevel() <= LOW_BATTERY;
    }
}
