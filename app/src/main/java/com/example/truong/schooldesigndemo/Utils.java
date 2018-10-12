package com.example.truong.schooldesigndemo;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ImageViewCompat;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.truong.schooldesigndemo.constanst.Constanst;

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

    public static SpannableStringBuilder setTextCameraOn(String text, String onNum, String totalNum, String on) {
        SpannableStringBuilder ssBuilder = new SpannableStringBuilder(text);
        try {
            // Apply the strike through text to the span
            ssBuilder.setSpan(new StyleSpan(Typeface.BOLD)
                    , text.indexOf(onNum)
                    , text.indexOf(onNum) + String.valueOf(onNum).length()
                    , Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            ssBuilder.setSpan(new ForegroundColorSpan(Color.BLACK)
                    , text.indexOf(onNum)
                    , text.indexOf(onNum) + String.valueOf(onNum).length()
                    , Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            ssBuilder.setSpan(new RelativeSizeSpan(1.8f)
                    , text.indexOf(onNum)
                    , text.indexOf(onNum) + String.valueOf(onNum).length()
                    , Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


            ssBuilder.setSpan(new ForegroundColorSpan(Color.BLACK)
                    , text.indexOf(totalNum)
                    , text.indexOf(totalNum) + String.valueOf(totalNum).length()
                    , Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            ssBuilder.setSpan(new RelativeSizeSpan(1.3f)
                    , text.indexOf(totalNum)
                    , text.indexOf(totalNum) + String.valueOf(totalNum).length()
                    , Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            ssBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#7EB64A"))
                    , text.indexOf(on)
                    , text.indexOf(on) + String.valueOf(on).length()
                    , Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            ssBuilder.setSpan(new RelativeSizeSpan(1.3f)
                    , text.indexOf(on)
                    , text.indexOf(on) + String.valueOf(on).length()
                    , Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            ssBuilder.setSpan(new StyleSpan(Typeface.BOLD)
                    , text.indexOf(on)
                    , text.indexOf(on) + String.valueOf(on).length()
                    , Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        } catch (Throwable e) {
            Log.e("NotificationFragment", "strikeThroughEstimateFare: ", e);
        }
        return ssBuilder;
    }

    /**
     * Converting dp to pixel
     */
    public static int dpToPx(Context context, int dp) {
        if (context != null) {
            Resources r = context.getResources();
            return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics())) > 0 ? Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics())) : 0;
        } else {
            return dp;
        }
    }

    public static String getRoomName(Context context, String type) {
        try {
            if (Utils.isNullOrEmpty(type))
                return "";
            else {
                Resources r = context.getResources();
                switch (type) {
                    case Constanst.Room.BATH_ROOM:
                        return r.getString(R.string.room_bath);
                    case Constanst.Room.BED_ROOM:
                        return r.getString(R.string.room_bed);
                    case Constanst.Room.KITCHEN_ROOM:
                        return r.getString(R.string.room_kitchen);
                    case Constanst.Room.LIBRARY:
                        return r.getString(R.string.room_library);
                    case Constanst.Room.LIVING_ROOM:
                        return r.getString(R.string.room_living);
                    case Constanst.Device.LIGHTING:
                        return r.getString(R.string.dv_light);
                    case Constanst.Device.GAS:
                        return r.getString(R.string.dv_gas);
                    case Constanst.Device.DOOR:
                        return r.getString(R.string.dv_door);
                    case Constanst.Device.CAMERA:
                        return r.getString(R.string.dv_camera);
                    case Constanst.Device.TEMP:
                        return r.getString(R.string.dv_temp);
                    default:
                        return "";
                }
            }
        } catch (Throwable e) {
            Log.e(TAG, "getRoomName: ", e);
            return "";
        }
    }

    public static Drawable getRoomImage(Context context, String type) {
        try {
            if (Utils.isNullOrEmpty(type))
                return ContextCompat.getDrawable(context, R.drawable.ic_light);
            else {
                switch (type) {
                    case Constanst.Room.BATH_ROOM:
                        return ContextCompat.getDrawable(context, R.drawable.room_bath);
                    case Constanst.Room.BED_ROOM:
                        return ContextCompat.getDrawable(context, R.drawable.room_bed);
                    case Constanst.Room.KITCHEN_ROOM:
                        return ContextCompat.getDrawable(context, R.drawable.room_kitchen);
                    case Constanst.Room.LIBRARY:
                        return ContextCompat.getDrawable(context, R.drawable.room_library);
                    case Constanst.Room.LIVING_ROOM:
                        return ContextCompat.getDrawable(context, R.drawable.room_living);
                    case Constanst.Device.LIGHTING:
                        return ContextCompat.getDrawable(context, R.drawable.ic_light);
                    case Constanst.Device.GAS:
                        return ContextCompat.getDrawable(context, R.drawable.ic_gas);
                    case Constanst.Device.DOOR:
                        return ContextCompat.getDrawable(context, R.drawable.ic_door);
                    case Constanst.Device.CAMERA:
                        return ContextCompat.getDrawable(context, R.drawable.ic_camera);
                    case Constanst.Device.TEMP:
                        return ContextCompat.getDrawable(context, R.drawable.ic_temp);
                    default:
                        return ContextCompat.getDrawable(context, R.drawable.ic_light);
                }
            }
        } catch (Throwable e) {
            Log.e(TAG, "getRoomName: ", e);
            return ContextCompat.getDrawable(context, R.drawable.ic_light);
        }
    }
}
