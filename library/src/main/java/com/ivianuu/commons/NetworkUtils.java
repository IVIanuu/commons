package com.ivianuu.commons;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

import com.ivianuu.commons.Commons;

/**
 * The type Network utils.
 */
public class NetworkUtils {

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
