package com.example.truong.schooldesigndemo;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ImageViewCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.MessageFormat;

public class Utils {
    private static final String TAG = Utils.class.getSimpleName();

    public static void setError(Context context, View v, TextView tv, ImageView img, String ms) {
        setTextError(context, tv, ms);
        setBackgroundError(context, v);
        setImageError(context, img);
    }

    public static void setDefault(Context context, View v, TextView tv, ImageView img, String ms) {
        setTextDefault(context, tv, ms);
        setBackgroundDefault(context, v);
        setImageDefault(context, img);
    }

    private static void setTextError(Context context, TextView tvError, String messenger) {
        if (tvError != null) {
            tvError.setTextColor(ContextCompat.getColor(context, R.color.text_error_color));
            tvError.setText(messenger);
        }
    }

    private static void setBackgroundError(Context context, View view) {
        if (view != null)
            view.setBackground(ContextCompat.getDrawable(context, R.drawable.et_bg_error));
    }

    private static void setBackgroundDefault(Context context, View view) {
        if (view != null)
            view.setBackground(ContextCompat.getDrawable(context, R.drawable.et_bg));
    }

    private static void setImageError(Context context, ImageView imageView) {
        if (imageView != null)
            ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(ContextCompat.getColor(context, R.color.text_error_color)));
    }

    private static void setImageDefault(Context context, ImageView imageView) {
        if (imageView != null)
            ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(ContextCompat.getColor(context, R.color.gray)));
    }

    private static void setTextDefault(Context context, TextView tvError, String messenger) {
        if (tvError != null) {
            tvError.setTextColor(ContextCompat.getColor(context, R.color.gray));
            tvError.setText(messenger);
        }
    }

    public static int getColorPrimary(Context context) {
        return ContextCompat.getColor(context, R.color.colorPrimary);
    }

    public static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    public static String format(String message, Object... objects) {
        MessageFormat form = new MessageFormat(message);
        return form.format(objects);
    }

}
