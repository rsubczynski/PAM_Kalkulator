package com.radoslaw.subczynski.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.radoslaw.subczynski.user.myapplication.MainActivity.KEY_CALCULATOR;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvResult;
    private String number = "";
    CalculatorApi calculatorApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        RelativeLayout relativeLayout = findViewById(R.id.relativeLayoutSimpleCalc);
        LinearLayout linearLayout = findViewById(R.id.linearLayoutAdvencedCalc);
        if (getIntent().getBooleanExtra(KEY_CALCULATOR, false)) {
            linearLayout.setVisibility(View.GONE);
        }
        initView();
        calculatorApi = new CalculatorApi();
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
        Button buttonComma = findViewById(R.id.button_comma);
        Button buttonAdd = findViewById(R.id.button_add);
        Button buttonMinus = findViewById(R.id.button_minus);
        Button buttonPercent = findViewById(R.id.button_percent);
        Button buttonMultiplication = findViewById(R.id.button_multiplication);
        Button buttonDivision = findViewById(R.id.button_division);
        Button buttonEquals = findViewById(R.id.button_equal);
        Button buttonElement = findViewById(R.id.button_element);
        Button buttonPower = findViewById(R.id.button_power);
        Button buttonFraction = findViewById(R.id.button_fraction);
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
        buttonComma.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonPercent.setOnClickListener(this);
        buttonMultiplication.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);
        buttonEquals.setOnClickListener(this);
        buttonElement.setOnClickListener(this);
        buttonPower.setOnClickListener(this);
        buttonFraction.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
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
            case R.id.button_comma:
                addText(".");
                break;
            case R.id.button_add:
                calculatorApi.add(toFloat());
                cleanTv();
                break;
            case R.id.button_minus:
                calculatorApi.minus(toFloat());
                cleanTv();
                break;
            case R.id.button_percent:
                cleanTv();
                break;
            case R.id.button_multiplication:
                calculatorApi.multiplication(toFloat());
                cleanTv();
                break;
            case R.id.button_division:
                calculatorApi.division(toFloat());
                cleanTv();
                break;
            case R.id.button_equal:
                calculatorApi.equal();
                cleanTv();
                break;
            case R.id.button_element:
                cleanTv();
                break;
            case R.id.button_power:
                cleanTv();
                break;
            case R.id.button_fraction:
                cleanTv();
                break;
        }

    }

    private void addText(String number) {
        this.number += number;
        tvResult.setText(this.number);
    }

    private void cleanTv() {
        number = "";
        tvResult.setText("");
    }

    private Float toFloat() {

        return Float.valueOf(String.valueOf(tvResult.getText()));
    }
}
