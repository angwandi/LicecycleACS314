package com.example.licecycle;

import android.content.Context;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SceneTransitionsActivity extends AppCompatActivity {
    private Context context;
    private int duration = Toast.LENGTH_SHORT;

    ViewGroup rootContainer;
    Scene scene1;
    Scene scene2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_transitions);
        context = getApplicationContext();

        rootContainer = findViewById(R.id.rootConatiner);
        scene1 = Scene.getSceneForLayout(rootContainer, R.layout.scene_1_layout, this);
        scene2 = Scene.getSceneForLayout(rootContainer, R.layout.scene_2_layout, this);
        scene1.enter();
    }

    public void goToScene2(View view) {
        TransitionManager.go(scene2);
    }

    public void goToScene1(View view) {
        TransitionManager.go(scene1);
    }
}
