package com.radoslaw.subczynski.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvSimpleCalc = findViewById(R.id.tvSimpleCalc);
        TextView tvCalc = findViewById(R.id.tvCalc);
        TextView tvExit = findViewById(R.id.tvExit);
        tvSimpleCalc.setOnClickListener(view -> OnSimpleCalcPressed());
        tvCalc.setOnClickListener(view -> OnCalcPressed());
        tvExit.setOnClickListener(view -> OnExitPressed());


    }

    private void OnExitPressed() {
        finish();
    }

    private void OnCalcPressed() {

    }

    private void OnSimpleCalcPressed() {

    }
}
