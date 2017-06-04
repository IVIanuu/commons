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

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;

/**
 * @author Manuel Wrage (IVIanuu)
 */

public final class RatingUtil {

    private RatingUtil() {}

    public static void openStoreRating(final @NonNull Context context) {
        openStoreRating(context, context.getPackageName());
    }

    /**
     * Opens the play store native app or the play store web site.
     */
    public static void openStoreRating(final @NonNull Context context, final @NonNull String packageName) {
        final Intent intent = new Intent(Intent.ACTION_VIEW);

        try {
            // First try to load the play store native application
            final Uri marketUri = Uri.parse("market://details?id=" + packageName);
            intent.setData(marketUri);
            context.startActivity(intent);
        } catch (ActivityNotFoundException __) {
            // Fallback to the play store web site
            final Uri httpUri = Uri.parse("http://play.google.com/store/apps/details?id=" + packageName);
            intent.setData(httpUri);
            context.startActivity(intent);
        }
    }
}
