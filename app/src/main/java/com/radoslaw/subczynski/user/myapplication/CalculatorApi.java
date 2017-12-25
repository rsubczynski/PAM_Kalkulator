package com.radoslaw.subczynski.user.myapplication;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by user on 25.12.2017.
 */

public class CalculatorApi {

    private Map<Integer, Float> map = new LinkedHashMap<Integer, Float>();
    float tmp;

    void add(Float number) {
        map.put(Operaction.OPERACTION_TYPE_ADD, number);
    }

    void minus(Float number) {
        map.put(Operaction.OPERACTION_TYPE_MINUS, number);
    }

    void multiplication(Float number) {
        map.put(Operaction.OPERACTION_TYPE_MULTIPLICATIO, number);
    }

    void division(Float number) {
        map.put(Operaction.OPERACTION_TYPE_DIVISION, number);
    }

    void equal() {
        for (Map.Entry<Integer, Float> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Float value = entry.getValue();
            startOperation(key,value);
    }}

    private void startOperation(Integer key, Float value) {

        switch (key){
            case Operaction.OPERACTION_TYPE_ADD:

                break;
            case Operaction.OPERACTION_TYPE_MINUS:

                break;
            case Operaction.OPERACTION_TYPE_MULTIPLICATIO:

                break;
            case  Operaction.OPERACTION_TYPE_DIVISION:

                break;
        }
        float tmp = value;
    }

    interface CalculatorApiResult {
        void onCalculatedResult();
    }
}
