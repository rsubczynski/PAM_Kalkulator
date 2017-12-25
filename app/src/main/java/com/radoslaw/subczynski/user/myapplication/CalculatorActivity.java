package com.radoslaw.subczynski.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import static com.radoslaw.subczynski.user.myapplication.MainActivity.KEY_CALCULATOR;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        RelativeLayout relativeLayout = findViewById(R.id.relativeLayoutSimpleCalc);
        LinearLayout linearLayout = findViewById(R.id.linearLayoutAdvencedCalc);
        if(getIntent().getBooleanExtra(KEY_CALCULATOR,false)){
            linearLayout.setVisibility(View.GONE);
        }
    }
}
