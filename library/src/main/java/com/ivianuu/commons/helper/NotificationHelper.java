package com.ivianuu.commons.helper;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.RemoteInput;

import com.ivianuu.commons.Commons;

/**
 * The type Notification helper.
 */
public class NotificationHelper {

    public static String getNotificationText(StatusBarNotification statusBarNotification, String field) {
        return getNotificationText(statusBarNotification.getNotification(), field);
    }

    /**
     * Gets notification text.
     *
     * @param n     the n
     * @param field the field
     * @return the notification text
     */
    public static String getNotificationText(Notification n, String field) {
        String text = null;
        if (n != null) {
            Bundle extras = n.extras;
            CharSequence chars = extras.getCharSequence(field);
            text = chars != null ? chars.toString() : null;
        }
        return text;
    }

    public static String getNotificationTitle(StatusBarNotification n) {
        return getNotificationTitle(n.getNotification());
    }

    /**
     * Gets notification title.
     *
     * @param n the n
     * @return the notification title
     */
    public static String getNotificationTitle(Notification n) {
        return getNotificationText(n, Notification.EXTRA_TITLE);
    }

    public static NotificationCompat.Action extractRemote(StatusBarNotification statusBarNotification) {
        return extractRemote(statusBarNotification.getNotification());
    }

    /**
     * Extract remote notification compat . action.
     *
     * @param notification the notification
     * @return the notification compat . action
     */
    public static NotificationCompat.Action extractRemote(Notification notification) {
        NotificationCompat.WearableExtender wearableExtender = new NotificationCompat.WearableExtender(notification);
        for (NotificationCompat.Action action : wearableExtender.getActions()) {
            if (action != null && action.getRemoteInputs() != null) {
                if (action.getRemoteInputs() != null) {
                    return action;
                }
            }
        }
        return null;
    }

    /**
     * Send reply.
     *
     * @param action the action
     * @param text   the text
     */
    public static void sendReply(NotificationCompat.Action action, String text) {
        if (action == null) {
            return;
        }

        RemoteInput[] remoteInputs = action.getRemoteInputs();
        PendingIntent pendingIntent = action.actionIntent;
        Intent intent = new Intent();
        intent.addFlags(268435456);
        Bundle bundle = new Bundle();
        for (RemoteInput remoteIn : remoteInputs) {
            bundle.putCharSequence(remoteIn.getResultKey(), text);
        }

        RemoteInput.addResultsToIntent(remoteInputs, intent, bundle);
        try {
            pendingIntent.send(Commons.getContext(), 0, intent);
        } catch (PendingIntent.CanceledException e) {
            // error
        }
    }

    public static boolean canReply(StatusBarNotification statusBarNotification) {
        return canReply(statusBarNotification.getNotification());
    }

    public static boolean canReply(Notification notification) {
        return NotificationHelper.extractRemote(notification) != null;
    }

    public static boolean hasAction(StatusBarNotification statusBarNotification) {
        return hasActions(statusBarNotification.getNotification());
    }

    public static boolean hasActions(Notification notification) {
        return notification.actions != null && notification.actions.length > 0;
    }

}
