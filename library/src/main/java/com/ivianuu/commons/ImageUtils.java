package com.ivianuu.commons;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatDrawableManager;
import android.util.Base64;

import com.ivianuu.commons.Commons;
import com.ivianuu.commons.Utils;

import java.io.ByteArrayOutputStream;

/**
 * The type Image helper.
 */
public class ImageUtils {

    /**
     * Bitmap to string string.
     *
     * @param bitmap the bitmap
     * @return the string
     */
    public static String bitmapToString(Bitmap bitmap) {
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
    public static Bitmap stringToBitmap(String encoded) {
        byte[] imageAsBytes = Base64.decode(encoded.getBytes(), 0);
        return BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
    }

    /**
     * Drawable to bitmap bitmap.
     *
     * @param drawable the drawable
     * @return the bitmap
     */
    public static Bitmap drawableToBitmap (Drawable drawable) {
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
    public static Bitmap vectorDrawableToBitmap(int drawableId) {
        @SuppressLint("RestrictedApi")
        Drawable drawable = AppCompatDrawableManager.get().getDrawable(Commons.getContext(), drawableId);
        if (!SdkUtils.isLollipop()) {
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
