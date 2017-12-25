package com.radoslaw.subczynski.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.radoslaw.subczynski.user.myapplication.MainActivity.KEY_CALCULATOR;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvResult;
    private String number = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        RelativeLayout relativeLayout = findViewById(R.id.relativeLayoutSimpleCalc);
        LinearLayout linearLayout = findViewById(R.id.linearLayoutAdvencedCalc);
        if(getIntent().getBooleanExtra(KEY_CALCULATOR,false)){
            linearLayout.setVisibility(View.GONE);
        }
        initView();
    }

    private void initView() {
        Button button0 = findViewById(R.id.button_0);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);
        tvResult = findViewById(R.id.et_result);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_0:
                addText("0");
                break;
            case R.id.button_1:
                addText("1");
                break;
            case R.id.button_2:
                addText("2");
                break;
            case R.id.button_3:
                addText("3");
                break;
            case R.id.button_4:
                addText("4");
                break;
            case R.id.button_5:
                addText("5");
                break;
            case R.id.button_6:
                addText("6");
                break;
            case R.id.button_7:
                addText("7");
                break;
            case R.id.button_8:
                addText("8");
                break;
            case R.id.button_9:
                addText("9");
                break;
        }
    }
    private void addText(String number){
        this.number += number;
        tvResult.setText(this.number);
    }
}
