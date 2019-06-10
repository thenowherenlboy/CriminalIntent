package com.bignerdranch.android.criminalintent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.app.Activity;
import android.graphics.Point;

public class PictureUtils {

    public static Bitmap getScaledBitmap(String path, Activity activity) {
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);
        return getScaledBitmap(path, size.x, size.y);
    }

    public static Bitmap getScaledBitmap(String path, int desWidth, int desHeight) {
        // Read in the dimensions of the image on disk
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;

        // Figure out how much to scale down by
        int insampleSize = 1;
        if (srcHeight > desHeight || srcWidth > desWidth) {
            float heightScale = srcHeight / desHeight;
            float widthScale = srcWidth / desWidth;

            insampleSize = Math.round(heightScale > widthScale ? heightScale: widthScale);
        }
        options = new BitmapFactory.Options();
        options.inSampleSize = insampleSize;

        // Read in and create final bitmap

        return BitmapFactory.decodeFile(path, options);

    }

}
