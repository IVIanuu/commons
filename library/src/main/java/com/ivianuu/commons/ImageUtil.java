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

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatDrawableManager;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

/**
 * @author Manuel Wrage (IVIanuu)
 */
public final class ImageUtil {

    private ImageUtil() {}

    /**
     * Bitmap to string string.
     *
     * @param bitmap the bitmap
     * @return the string
     */
    @NonNull
    public static String bitmapToString(@NonNull Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] b = byteArrayOutputStream.toByteArray();
        return  Base64.encodeToString(b, Base64.DEFAULT);
    }

    /**
     * String to bitmap bitmap.
     *
     * @param encoded the encoded
     * @return the bitmap
     */
    @NonNull
    public static Bitmap stringToBitmap(@NonNull String encoded) {
        byte[] imageAsBytes = Base64.decode(encoded.getBytes(), 0);
        return BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
    }

    /**
     * Drawable to bitmap bitmap.
     *
     * @param drawable the drawable
     * @return the bitmap
     */
    @NonNull
    public static Bitmap drawableToBitmap(@NonNull Drawable drawable) {
        Bitmap bitmap;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if(bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }

        if(drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * Vector drawable to bitmap bitmap.
     *
     * @param drawableId the drawable id
     * @return the bitmap
     */
    @NonNull
    public static Bitmap vectorDrawableToBitmap(@NonNull int drawableId) {
        @SuppressLint("RestrictedApi")
        Drawable drawable = AppCompatDrawableManager.get().getDrawable(Commons.getContext(), drawableId);
        if (!SdkUtil.isLollipop()) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }
}
