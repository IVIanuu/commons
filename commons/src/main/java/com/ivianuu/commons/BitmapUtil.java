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

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Px;

/**
 * Bitmap utils
 */
public final class BitmapUtil {

    private BitmapUtil() {
        // no instances
    }

    /**
     * Returns the resized bitmap
     */
    @NonNull
    public static Bitmap resize(@NonNull Bitmap bitmap, @Px int width, @Px int height) {
        final int srcWidth = bitmap.getWidth();
        final int srcHeight = bitmap.getHeight();

        final float widthRatio = (float) srcWidth / (float) width;
        final float heightRatio = (float) srcHeight / (float) height;

        if (widthRatio < heightRatio) {
            final Bitmap scaleBitmap = Bitmap.createScaledBitmap(bitmap, width, Math.round(srcHeight / widthRatio), true);
            return Bitmap.createBitmap(scaleBitmap, 0, Math.round((scaleBitmap.getHeight() - height) / 2.0f), width, height);
        } else {
            final Bitmap scaleBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(srcWidth / heightRatio), height, true);

            return Bitmap.createBitmap(scaleBitmap, Math.round((scaleBitmap.getWidth() - width) / 2.0f), 0, width, height);
        }
    }
}
