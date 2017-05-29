package com.ivianuu.commons;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.RemoteInput;

/**
 * @author Manuel Wrage (IVIanuu)
 */
@TargetApi(Build.VERSION_CODES.KITKAT)
public class NotificationUtil {

    @Nullable
    public static String getNotificationText(@NonNull StatusBarNotification statusBarNotification,@NonNull String field) {
        return getNotificationText(statusBarNotification.getNotification(), field);
    }

    /**
     * Gets notification text.
     *
     * @param n     the n
     * @param field the field
     * @return the notification text
     */
    @Nullable
    public static String getNotificationText(@NonNull Notification n,@NonNull String field) {
        String text;
        Bundle extras = n.extras;
        CharSequence chars = extras.getCharSequence(field);
        text = chars != null ? chars.toString() : null;
        return text;
    }

    @Nullable
    public static String getNotificationTitle(@NonNull StatusBarNotification n) {
        return getNotificationTitle(n.getNotification());
    }

    /**
     * Gets notification title.
     *
     * @param n the n
     * @return the notification title
     */
    @Nullable
    public static String getNotificationTitle(@NonNull Notification n) {
        return getNotificationText(n, Notification.EXTRA_TITLE);
    }

    @Nullable
    public static NotificationCompat.Action extractRemote(@NonNull StatusBarNotification statusBarNotification) {
        return extractRemote(statusBarNotification.getNotification());
    }

    /**
     * Extract remote notification compat . action.
     *
     * @param notification the notification
     * @return the notification compat . action
     */
    @Nullable
    public static NotificationCompat.Action extractRemote(@NonNull Notification notification) {
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
    public static void sendReply(@NonNull NotificationCompat.Action action,@NonNull String text) {
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

    public static boolean canReply(@NonNull StatusBarNotification statusBarNotification) {
        return canReply(statusBarNotification.getNotification());
    }

    public static boolean canReply(@NonNull Notification notification) {
        return NotificationUtil.extractRemote(notification) != null;
    }

    public static boolean hasAction(@NonNull StatusBarNotification statusBarNotification) {
        return hasActions(statusBarNotification.getNotification());
    }

    public static boolean hasActions(@NonNull Notification notification) {
        return notification.actions != null && notification.actions.length > 0;
    }

}
