package com.lewisen.goodnight.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.lewisen.goodnight.R;
import com.lewisen.goodnight.controller.IDManage;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(this, R.layout.activity_main, null);
        view.findViewById(R.id.first_text).setVisibility(View.VISIBLE);
        view.findViewById(R.id.wanan_image).setVisibility(View.VISIBLE);
        view.findViewById(R.id.wanan_text).setVisibility(View.VISIBLE);
        setContentView(view);

        // 渐变展示启动屏,这里通过动画来设置了开启应用程序的界面
        AlphaAnimation aa = new AlphaAnimation(0.3f, 1.0f);
        aa.setDuration(2000);
        view.startAnimation(aa);
        // 给动画添加监听方法
        aa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation arg0) {
                //跳转到第二屏
                redirectToSecond();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationStart(Animation animation) {
            }

        });

        //加载最大值
        IDManage.setMaxID(null);
        //加载第二屏图片
        new SecondImage().loadSecondImagePath();
    }

    /**
     * 跳转到第二屏界面的方法
     */
    private void redirectToSecond() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in,
                android.R.anim.fade_out);

        finish();
    }

//    private void redirectToMain() {
//        Intent intent = new Intent(this, MainView.class);
//        startActivity(intent);
//        overridePendingTransition(android.R.anim.fade_in,
//                android.R.anim.fade_out);
//
//        finish();
//    }


}
