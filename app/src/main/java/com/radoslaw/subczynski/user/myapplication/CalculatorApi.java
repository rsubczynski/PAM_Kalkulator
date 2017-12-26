package com.radoslaw.subczynski.user.myapplication;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import static com.radoslaw.subczynski.user.myapplication.Operaction.OPERACTION_TYPE_ADD;
import static com.radoslaw.subczynski.user.myapplication.Operaction.OPERACTION_TYPE_DIVISION;
import static com.radoslaw.subczynski.user.myapplication.Operaction.OPERACTION_TYPE_MINUS;
import static com.radoslaw.subczynski.user.myapplication.Operaction.OPERACTION_TYPE_MULTIPLICATIO;

/**
 * Created by user on 25.12.2017.
 */

public class CalculatorApi {

    private String tmp = "";
    private CalculatorApiResult listener;

    public CalculatorApi(CalculatorApiResult listener) {
        this.listener = listener;
    }

    void add(String number) {
        startOperation(OPERACTION_TYPE_ADD, number);
    }

    void minus(String number) {
        startOperation(OPERACTION_TYPE_MINUS, number);
    }

    void multiplication(String number) {
        startOperation(OPERACTION_TYPE_MULTIPLICATIO, number);
    }

    void division(String number) {
        startOperation(OPERACTION_TYPE_DIVISION, number);
    }

    void equal() {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        if (!listener.getLast().equals("")) {
            tmp += listener.getLast();
        }
        else
        {
            tmp += "0";
        }

        try {
            int res = ((Double) engine.eval(tmp)).intValue();
            listener.onCalculatedResult(String.valueOf(res));
            tmp = "";
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        tmp = "";
    }

    private void startOperation(Integer key, String value) {

        switch (key) {
            case OPERACTION_TYPE_ADD:
                tmp += value + "+";
                break;
            case Operaction.OPERACTION_TYPE_MINUS:
                tmp += value + "-";
                break;
            case Operaction.OPERACTION_TYPE_MULTIPLICATIO:
                tmp += value + "*";
                break;
            case Operaction.OPERACTION_TYPE_DIVISION:
                tmp += value + "/";
                break;
        }
        System.out.println(tmp);
    }

    interface CalculatorApiResult {
        void onCalculatedResult(String dupa);

        String getLast();

    }
}
