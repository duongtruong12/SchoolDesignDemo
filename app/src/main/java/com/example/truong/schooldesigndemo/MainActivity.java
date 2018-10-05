package com.example.truong.schooldesigndemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.truong.schooldesigndemo.Activity.CommonActivity;
import com.example.truong.schooldesigndemo.Activity.HomeActivity;
import com.example.truong.schooldesigndemo.CustomView.PlaceHolderInfoDefault;

public class MainActivity extends CommonActivity implements View.OnClickListener {
    private RelativeLayout rlLogin;
    private TextView tvSignUp;
    private TextView tvErrorUserName;
    private TextView tvErrorPassword;
    private ImageView imgErrorUserName, imgErrorPassword;
    private CountDownTimer countDownTimer;
    private LinearLayout llLogo;
    private PlaceHolderInfoDefault edtUserName, edtPassword;
    private Animation animFadeOut;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        installView();
    }

    private void installView() {
        try {
            installToolbar();

            rlLogin = findViewById(R.id.rl_login);

            tvSignUp = findViewById(R.id.tv_sign_up);
            tvErrorUserName = findViewById(R.id.tv_error_user_name);
            tvErrorPassword = findViewById(R.id.tv_error_password);
            TextView tvForgotPass = findViewById(R.id.tv_forgot_password);

            imgErrorUserName = findViewById(R.id.img_error_user);
            imgErrorPassword = findViewById(R.id.img_error_pass);
            llLogo = findViewById(R.id.ll_logo);

            edtUserName = findViewById(R.id.edt_username);
            edtPassword = findViewById(R.id.edt_password);

            Button btnLogin = findViewById(R.id.btn_login);
            RelativeLayout rlTotalView = findViewById(R.id.rl_total_view);

            animFadeOut = AnimationUtils.loadAnimation(context, R.anim.fade_out);

            edtUserName.setImageViewError(imgErrorUserName);
            edtPassword.setImageViewError(imgErrorPassword);
            edtUserName.setTextViewError(tvErrorUserName, getString(R.string.user_name));
            edtPassword.setTextViewError(tvErrorPassword, getString(R.string.password));

            installSplashScreen();

            rlViewToolbar.setVisibility(View.GONE);
            btnLogin.setOnClickListener(this);
            tvSignUp.setOnClickListener(this);
            rlTotalView.setOnClickListener(this);
            tvForgotPass.setOnClickListener(this);
        } catch (Throwable e) {
            Log.e(TAG, "installView: ", e);
        }
    }

    private void installSplashScreen() {
        try {
            countDownTimer = new CountDownTimer(1000, 2000) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    rlLogin.setVisibility(View.VISIBLE);
                    tvSignUp.setVisibility(View.VISIBLE);
                }
            };
            animFadeOut.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    countDownTimer.start();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            llLogo.startAnimation(animFadeOut);
        } catch (Throwable e) {
            Log.e(TAG, "installSplashScreen: ", e);
        }
    }

    private boolean checkInfo() {
        String username = edtUserName.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        boolean success = true;
        if (Utils.isNullOrEmpty(username)) {
            success = false;
            Utils.setError(context, edtUserName, tvErrorUserName, imgErrorUserName, Utils.format(getString(R.string.incorrect_format), getString(R.string.user_name)));
            edtUserName.setError(true);
        }

        if (Utils.isNullOrEmpty(password)) {
            success = false;
            Utils.setError(context, edtPassword, tvErrorPassword, imgErrorPassword, Utils.format(getString(R.string.incorrect_format), getString(R.string.password)));
            edtPassword.setError(true);
        }
        return success;
    }

    private void loginMethod() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                if (checkInfo()) {
                    loginMethod();
                }
                break;
            case R.id.tv_sign_up:
                break;
            default:
                hideKeyBroad();
                break;
        }
    }
}