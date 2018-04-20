package com.example.pccs_0007.youtubetest;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TestActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    private ConstraintSet applyConstraintSet = new ConstraintSet();
    private ConstraintSet resetConstraintSet = new ConstraintSet();
    Button apply,reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        constraintLayout = findViewById(R.id.main);
        applyConstraintSet.clone(constraintLayout);
        resetConstraintSet.clone(constraintLayout);


        apply = findViewById(R.id.apply);
        reset = findViewById(R.id.reset);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyConstraintSet.setMargin(R.id.button1,ConstraintSet.START,8);
                applyConstraintSet.applyTo(constraintLayout);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetConstraintSet.applyTo(constraintLayout);
            }
        });

    }
}
