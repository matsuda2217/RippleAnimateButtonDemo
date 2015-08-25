package com.example.tt.rippleanimatebuttondemo;

import android.animation.Animator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image);
    }

    public void animateImg(View view) {
        if (imageView.getVisibility() == View.VISIBLE) {
            hideImgCircular();
        } else {
            showImgCircular();
        }
    }

    public void hideImgCircular() {
        int cx = (imageView.getLeft() + imageView.getRight()) / 2;
        int cy = (imageView.getBottom() + imageView.getTop()) / 2;

        int intitalRadius = imageView.getWidth();
        Animator anim = ViewAnimationUtils.createCircularReveal(imageView, cx, cy, intitalRadius, 0);

        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                imageView.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        anim.setDuration(1000);
        anim.start();

    }

    public void showImgCircular() {
        int cx = (imageView.getLeft() + imageView.getRight()) / 2;
        int cy = (imageView.getBottom() + imageView.getTop()) / 2;

        int endRadius = Math.max(imageView.getHeight(),imageView.getWidth());

        Animator anim = ViewAnimationUtils.createCircularReveal(imageView, cx, cy, 0, endRadius);

        anim.setDuration(1000);
        imageView.setVisibility(View.VISIBLE);
        anim.start();
    }
}
