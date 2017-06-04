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
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.WindowManager;

import static com.ivianuu.commons.Commons.getContext;

/**
 * @author Manuel Wrage (IVIanuu)
 */
public final class ScreenUtil {

    private ScreenUtil() {}

    public static boolean isPortrait() {
        return !isLandscape();
    }

    /**
     * Is landscape boolean.
     *
     * @return the boolean
     */
    public static boolean isLandscape() {
        return getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    /**
     * Gets rotation.
     *
     * @return the rotation
     */
    public static int getRotation() {
        WindowManager windowManager =
                (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        return windowManager.getDefaultDisplay().getRotation();
    }

    /**
     * Gets screen width.
     *
     * @return the screen width
     */
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    /**
     * Gets screen height.
     *
     * @return the screen height
     */
    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

}
