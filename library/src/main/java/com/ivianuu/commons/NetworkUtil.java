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
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;

/**
 * @author Manuel Wrage (IVIanuu)
 */
public final class NetworkUtil {

    private NetworkUtil() {}

    /**
     * Is connected boolean.
     *
     * @return the boolean
     */
    public static boolean isConnected() {
        NetworkInfo info = getNetworkInfo();
        return (info != null && info.isConnected());
    }

    /**
     * Gets network info.
     *
     * @return the network info
     */
    @Nullable
    public static NetworkInfo getNetworkInfo() {
        ConnectivityManager cm =
                (ConnectivityManager) Commons.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();
    }

    /**
     * Is connected wifi boolean.
     *
     * @return the boolean
     */
    public static boolean isConnectedWifi() {
        NetworkInfo info = getNetworkInfo();
        return (info != null && info.isConnected() && info.getType() == ConnectivityManager.TYPE_WIFI);
    }

    /**
     * Is connected mobile boolean.
     *
     * @return the boolean
     */
    public static boolean isConnectedMobile() {
        NetworkInfo info = getNetworkInfo();
        return (info != null
                && info.isConnected()
                && info.getType() == ConnectivityManager.TYPE_MOBILE);
    }

    /**
     * Is connected fast boolean.
     *
     * @return the boolean
     */
    public static boolean isConnectedFast() {
        NetworkInfo info = getNetworkInfo();
        return (info != null && info.isConnected() && isConnectionFast(info.getType(),
                info.getSubtype()));
    }

    /**
     * Is connection fast boolean.
     *
     * @param type    the type
     * @param subType the sub type
     * @return the boolean
     */
    public static boolean isConnectionFast(int type, int subType) {
        if (type == ConnectivityManager.TYPE_WIFI) {
            return true;
        }
        else if (type == ConnectivityManager.TYPE_MOBILE) {
            switch (subType) {
                case TelephonyManager.NETWORK_TYPE_1xRTT:
                    return false;
                case TelephonyManager.NETWORK_TYPE_CDMA:
                    return false;
                case TelephonyManager.NETWORK_TYPE_EDGE:
                    return false;
                case TelephonyManager.NETWORK_TYPE_EVDO_0:
                    return true;
                case TelephonyManager.NETWORK_TYPE_EVDO_A:
                    return true;
                case TelephonyManager.NETWORK_TYPE_GPRS:
                    return false;
                case TelephonyManager.NETWORK_TYPE_HSDPA:
                    return true;
                case TelephonyManager.NETWORK_TYPE_HSPA:
                    return true;
                case TelephonyManager.NETWORK_TYPE_HSUPA:
                    return true;
                case TelephonyManager.NETWORK_TYPE_UMTS:
                    return true;
                case TelephonyManager.NETWORK_TYPE_EHRPD:
                    return true;
                case TelephonyManager.NETWORK_TYPE_EVDO_B:
                    return true;
                case TelephonyManager.NETWORK_TYPE_HSPAP:
                    return true;
                case TelephonyManager.NETWORK_TYPE_IDEN:
                    return false;
                case TelephonyManager.NETWORK_TYPE_LTE:
                    return true;
                case TelephonyManager.NETWORK_TYPE_UNKNOWN:
                default:
                    return false;
            }
        }
        else {
            return false;
        }
    }
}
