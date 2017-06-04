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
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.PowerManager;

import static com.ivianuu.commons.SdkUtil.isLollipop;

/**
 * @author Manuel Wrage (IVIanuu)
 */
public final class PowerUtil {

    private static final int LOW_BATTERY = 15;

    private PowerUtil() {}

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
                || (SdkUtil.isJellyBeanMr1() && plugged == BatteryManager.BATTERY_PLUGGED_WIRELESS);
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
