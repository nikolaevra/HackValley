package com.example.ruslan.chatapplication;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/**
 * Created by ruslan on 08/01/17.
 */

class Parameters {

    private final int HEIGHT = 150;
    private final int WIDTH = 120;

    Bitmap getScaledPin (Resources resources, int drawable) {
        BitmapDrawable bitmapdraw = (BitmapDrawable) resources.getDrawable(drawable);
        Bitmap b = bitmapdraw.getBitmap();
        return Bitmap.createScaledBitmap(b, WIDTH,  HEIGHT, false);
    }
}
