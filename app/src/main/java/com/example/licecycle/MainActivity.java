package com.example.licecycle;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.ChangeBounds;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private int duration = Toast.LENGTH_SHORT;
    ViewGroup myLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLayout = findViewById(R.id.myScreen1);
        myLayout.setOnTouchListener(new RelativeLayout.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                handleTouch();
                return true;
            }
        });
    }

    private void handleTouch() {
        View view = findViewById(R.id.button);
        Transition changeBounds = new ChangeBounds();
        changeBounds.setDuration(3000);
        changeBounds.setInterpolator(new BounceInterpolator());
        TransitionManager.beginDelayedTransition(myLayout, changeBounds);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        view.setLayoutParams(params);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = 500;
        layoutParams.height = 350;
        view.setLayoutParams(layoutParams);
    }
}
