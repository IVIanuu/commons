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
import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.WindowManager;

/**
 * @author Manuel Wrage (IVIanuu)
 */

public class ActivityUtil {

    // System Bars

    /**
     * Set' status and navigation bar color
     */
    public static void setSystemBarColor(@NonNull Activity activity, @ColorInt int color) {
        setStatusBarColor(activity, color);
        setNavigationBarColor(activity, color);
    }

    // Statusbar

    /**
     * Set's status bar color
     */
    @TargetApi(21)
    public static void setStatusBarColor(@NonNull Activity activity, @ColorInt int color) {
        if (SdkUtil.isLollipop()) {
            activity.getWindow().setStatusBarColor(ColorUtil.darkenColor(color));
        }
    }

    /**
     * Set's status bar light based on passed boolean
     */
    public static void setLightStatusBar(@NonNull Activity activity, boolean enabled) {
        if (SdkUtil.isMarshmallow()) {
            View decorView = activity.getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if(enabled) {
                decorView.setSystemUiVisibility(systemUiVisibility | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            } else {
                decorView.setSystemUiVisibility(systemUiVisibility &~ View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }
    }

    // Navigationbar

    /**
     * Set's Navigation bar color
     */
    public static void setNavigationBarColor(@NonNull Activity activity, @ColorInt int color) {
        if (SdkUtil.isLollipop()) {
            activity.getWindow().setNavigationBarColor(ColorUtil.darkenColor(color));
        }
    }

    // Task description

    /**
     * Set's task description color
     */
    public static void setTaskDescriptionColor(@NonNull Activity activity, @ColorInt int color) {
        if (SdkUtil.isLollipop()) {
            // Task description requires fully opaque color
            color = ColorUtil.stripAlpha(color);
            // Sets color of entry in the system recents page
            activity.setTaskDescription(new ActivityManager.TaskDescription((String) activity.getTitle(), null, color));
        }
    }

    // SystemBars

    /**
     * Set's system bars translucent
     */
    public static void setTranslucentSystemBars(@NonNull Activity activity, boolean enabled) {
        setTranslucentStatusBar(activity, enabled);
        setTranslucentNavigationBar(activity, enabled);
    }

    /**
     * Set's system bars transparent
     */
    public static void setTransparentSystemBars(@NonNull Activity activity, boolean enabled) {
        setTransparentStatusBar(activity, enabled);
        setTransparentNavigationBar(activity, enabled);
    }

    /**
     * Set's system bars hidden
     */
    public static void setSystemBarsHidden(@NonNull Activity activity, boolean hidden) {
        setStatusBarHidden(activity, hidden);
        setNavigationBarHidden(activity, hidden);
    }

    // StatusBar
    /**
     * Set's draw under status bar enabled
     */
    public static void setDrawUnderStatusBar(@NonNull Activity activity, boolean enabled) {
        if (SdkUtil.isLollipop()) {
            activity.getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
    }

    /**
     * Set's status bar translucent
     */
    @TargetApi(19)
    public static void setTranslucentStatusBar(@NonNull Activity activity, boolean enabled) {
        WindowManager.LayoutParams winParams = activity.getWindow().getAttributes();
        if (enabled) {
            winParams.flags |= WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        } else {
            winParams.flags &= ~WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        }
    }

    /**
     * Set's status bar transparent
     */
    public static void setTransparentStatusBar(@NonNull Activity activity, boolean enabled) {
        if (SdkUtil.isLollipop()) {
            if (enabled) {
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                setStatusBarColor(activity, Color.TRANSPARENT);
            } else {
                activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            }

            setDrawUnderStatusBar(activity, enabled);
        }
    }

    /**
     * Set's status bar hidden
     */
    public static void setStatusBarHidden(@NonNull Activity activity, boolean hidden) {
        if (hidden) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    // NavigationBar
    /**
     * Set's navigation bar translucent
     */
    @TargetApi(19)
    public static void setTranslucentNavigationBar(@NonNull Activity activity, boolean enabled) {
        WindowManager.LayoutParams winParams = activity.getWindow().getAttributes();
        if (enabled) {
            winParams.flags |= WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
        } else {
            winParams.flags &= ~WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
        }
    }

    /**
     * Set's navigation bar transparent
     */
    @TargetApi(21)
    public static void setTransparentNavigationBar(@NonNull Activity activity, boolean enabled) {
        if (SdkUtil.isLollipop()) {
            if (enabled) {
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            } else {
                activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            }
        }
    }

    /**
     * Set's navigation bar hidden
     */
    @TargetApi(19)
    public static void setNavigationBarHidden(@NonNull Activity activity, boolean enabled) {
        View decorView = activity.getWindow().getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        if(enabled) {
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                    View.SYSTEM_UI_FLAG_IMMERSIVE |
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        } else {
            systemUiVisibility = systemUiVisibility &~ View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
            systemUiVisibility = systemUiVisibility &~ View.SYSTEM_UI_FLAG_IMMERSIVE;
            systemUiVisibility = systemUiVisibility &~ View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(systemUiVisibility);
        }
    }
    
}
