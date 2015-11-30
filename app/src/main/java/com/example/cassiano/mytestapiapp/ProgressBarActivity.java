package com.example.cassiano.mytestapiapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Cassiano on 23/11/2015.
 */
public class ProgressBarActivity extends Activity {

    private ProgressBar progress;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);

        progress = (ProgressBar) findViewById(R.id.progress);
        text = (TextView) findViewById(R.id.label_msg);

        text.setVisibility(View.GONE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(5000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showContent();
                    }
                });
            }
        }).start();
    }

    private void showContent() {

        int duration = getResources().getInteger(android.R.integer.config_longAnimTime);

        text.setVisibility(View.VISIBLE);
        text.setAlpha(0.0f);

        text.animate()
                .alpha(1.0f)
                .setDuration(duration)
                .setListener(null);

        progress.animate().
                alpha(0.0f).
                setDuration(duration)
                .setListener(new AnimatorListenerAdapter() {
                      @Override
                      public void onAnimationEnd(Animator animation) {
                          progress.setVisibility(View.GONE);
                      }
                  }

        );
    }
}
