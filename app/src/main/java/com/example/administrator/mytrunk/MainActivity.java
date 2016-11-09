package com.example.administrator.mytrunk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout Backview, Supply,Tobuy,Mygq, Menu ;
    FrameLayout fmFilter;
    ImageView ivOperate;
    //操作按钮进场出场动画
    private Animation anim_right_in, anim_right_out, anim__bottom_in, anim_bottom_out, anim_rotate_open, anim_rotate_close, anim_scale_in, anim_scale_out;
    private boolean mOpenMenu = false;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initAnim();
        initListener();

    }
    /**
     * 控制菜单展开收缩
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void initView(){
        Backview = (LinearLayout) findViewById(R.id.ln_backview);
        Supply = (LinearLayout) findViewById(R.id.ln_supply);
        Tobuy = (LinearLayout) findViewById(R.id.ln_tobuy);
        Mygq = (LinearLayout) findViewById(R.id.ln_mygq);
        fmFilter = (FrameLayout) findViewById(R.id.fm_filter);
        Menu = (LinearLayout) findViewById(R.id.ln_menu);
        ivOperate = (ImageView) findViewById(R.id.iv_operate);

    }

    public void initListener(){
        Backview.setOnClickListener(this);
        Supply.setOnClickListener(this);
        Tobuy.setOnClickListener(this);
        Mygq.setOnClickListener(this);
        fmFilter.setOnClickListener(this);
        Menu.setOnClickListener(this);
        ivOperate.setOnClickListener(this);
    }



    public void controlMenu() {
        if (mOpenMenu) {
            mOpenMenu = false;
            Menu.startAnimation(anim_right_out);
            ivOperate.startAnimation(anim_rotate_close);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Mygq.startAnimation(anim_scale_out);
                    Tobuy.startAnimation(anim_scale_out);
                    Supply.startAnimation(anim_scale_out);
                }
            }, 0);
        } else {
            mOpenMenu = true;
            Backview.setVisibility(View.VISIBLE);
            Menu.startAnimation(anim_right_in);
            ivOperate.startAnimation(anim_rotate_open);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Mygq.startAnimation(anim_scale_in);
                    Tobuy.startAnimation(anim_scale_in);
                    Supply.startAnimation(anim_scale_in);
                }
            }, 0);
        }
    }
    /**
     * 初始化弹出框动画
     */
    private void initAnim() {
        if (anim_right_in == null) {
            anim_right_in = AnimationUtils.loadAnimation(this, R.anim.gq_menu_right_in);
            DecelerateInterpolator interpolator = new DecelerateInterpolator();
            anim_right_in.setInterpolator(interpolator);
            anim_right_in.setFillAfter(true);
        }

        if (anim_right_out == null) {
            anim_right_out = AnimationUtils.loadAnimation(this, R.anim.gq_menu_right_out);
            DecelerateInterpolator interpolator = new DecelerateInterpolator();
            anim_right_out.setInterpolator(interpolator);
            anim_right_out.setFillAfter(true);
        }


        if (anim__bottom_in == null) {
            anim__bottom_in = AnimationUtils.loadAnimation(this, R.anim.show_from_bottom);
            LinearInterpolator interpolator = new LinearInterpolator();
            anim__bottom_in.setInterpolator(interpolator);
            anim__bottom_in.setFillAfter(true);
        }

        if (anim_bottom_out == null) {
            anim_bottom_out = AnimationUtils.loadAnimation(this, R.anim.hide_to_bottom);
            LinearInterpolator interpolator = new LinearInterpolator();
            anim_bottom_out.setInterpolator(interpolator);
            anim_bottom_out.setFillAfter(true);
        }

        if (anim_rotate_open == null) {

            anim_rotate_open = AnimationUtils.loadAnimation(this, R.anim.rotate_0_45);
            BounceInterpolator interpolator = new BounceInterpolator();
            anim_rotate_open.setInterpolator(interpolator);
            anim_rotate_open.setFillAfter(true);
        }

        if (anim_rotate_close == null) {
            anim_rotate_close = AnimationUtils.loadAnimation(this, R.anim.rotate_45_0);
            BounceInterpolator interpolator = new BounceInterpolator();
            anim_rotate_close.setInterpolator(interpolator);
            anim_rotate_close.setFillAfter(true);
        }

        if (anim_scale_in == null) {
            anim_scale_in = AnimationUtils.loadAnimation(this, R.anim.scale_in);
            LinearInterpolator interpolator = new LinearInterpolator();
            anim_scale_in.setInterpolator(interpolator);
            anim_scale_in.setFillAfter(true);
        }

        if (anim_scale_out == null) {
            anim_scale_out = AnimationUtils.loadAnimation(this, R.anim.scale_out);
            LinearInterpolator interpolator = new LinearInterpolator();
            anim_scale_out.setInterpolator(interpolator);
            anim_scale_out.setFillAfter(true);
        }
    }

    @Override
    public void onClick(View view) {

            switch (view.getId()){

                case R.id.iv_operate:
                    controlMenu();
                    break;

            }
    }
}
