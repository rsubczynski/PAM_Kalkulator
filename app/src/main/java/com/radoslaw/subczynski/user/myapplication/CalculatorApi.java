package com.radoslaw.subczynski.user.myapplication;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by user on 25.12.2017.
 */

public class CalculatorApi {

    private Map<Integer, String> map = new LinkedHashMap<Integer, String>();
    private String tmp = "";
    private CalculatorApiResult listener;

    public CalculatorApi(CalculatorApiResult listener) {
        this.listener = listener;
    }

    void add(String number) {
        map.put(Operaction.OPERACTION_TYPE_ADD, number);
    }

    void minus(String number) {
        map.put(Operaction.OPERACTION_TYPE_MINUS, number);
    }

    void multiplication(String number) {
        map.put(Operaction.OPERACTION_TYPE_MULTIPLICATIO, number);
    }

    void division(String number) {
        map.put(Operaction.OPERACTION_TYPE_DIVISION, number);
    }

    void equal() {
        tmp = "";

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            startOperation(key, value);
        }
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try {
            int res = ((Double) engine.eval(tmp)).intValue();
            listener.onCalculatedResult(String.valueOf(res));

        } catch (ScriptException e) {
            e.printStackTrace();
        }
        map.clear();
    }

    private void startOperation(Integer key, String value) {

        switch (key) {
            case Operaction.OPERACTION_TYPE_ADD:
                if (listener.getLast().equals("")) {
                    tmp += value;
                } else {
                    tmp += value + "+" + listener.getLast();
                }
                break;
            case Operaction.OPERACTION_TYPE_MINUS:
                if (listener.getLast().equals("")) {
                    tmp += value;
                } else {
                    tmp += value + "-" + listener.getLast();
                }
                break;
            case Operaction.OPERACTION_TYPE_MULTIPLICATIO:
                if (listener.getLast().equals("")) {
                    tmp += value;
                } else {
                    tmp += value + "*" + listener.getLast();
                }
                break;
            case Operaction.OPERACTION_TYPE_DIVISION:
                if (listener.getLast().equals("")) {
                    tmp += value;
                } else {
                    tmp += value + "/" + listener.getLast();
                }
                break;
        }

    }

    interface CalculatorApiResult {
        void onCalculatedResult(String dupa);

        String getLast();

    }
}
