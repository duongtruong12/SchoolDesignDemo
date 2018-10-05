package com.example.truong.schooldesigndemo.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.view.WindowManager;

import com.example.truong.schooldesigndemo.R;


public class ProgressBarDialog extends Dialog {

    @Override
    public void onBackPressed() {
        dismiss();
    }

    public ProgressBarDialog(Context context) {
        super(context);
        Window window = this.getWindow();
        if (window != null) {
            window.requestFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.dialog_progess_bar);
            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            lp.copyFrom(window.getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.MATCH_PARENT;
            window.setAttributes(lp);
            window.getAttributes().windowAnimations = android.R.style.Animation_Dialog;
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            setCanceledOnTouchOutside(false);
        }
    }
}
