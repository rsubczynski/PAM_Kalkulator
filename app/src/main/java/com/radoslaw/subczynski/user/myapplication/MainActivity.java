package com.radoslaw.subczynski.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final static String KEY_CALCULATOR = "calculatorKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvSimpleCalc = findViewById(R.id.tvSimpleCalc);
        TextView tvCalc = findViewById(R.id.tvCalc);
        TextView tvExit = findViewById(R.id.tvExit);
        tvSimpleCalc.setOnClickListener(view -> OnSimpleCalcPressed());
        tvCalc.setOnClickListener(view -> OnAdvanceCalcPressed());
        tvExit.setOnClickListener(view -> OnExitPressed());


    }

    private void OnExitPressed() {
        finish();
    }

    private void OnAdvanceCalcPressed() {
        ShowCalculator(false);
    }

    private void OnSimpleCalcPressed() {
        ShowCalculator(true);
    }

    private void ShowCalculator(boolean isSimple) {
        Intent intent = new Intent(getBaseContext(), CalculatorActivity.class);
        intent.putExtra(KEY_CALCULATOR,isSimple);
        startActivity(intent);
    }
}
