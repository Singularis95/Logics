package com.company;

import java.util.ArrayList;

public class Calc {

    private String[] expression;
    private int varPriority = 0;

    ArrayList <Integer> priority = new ArrayList<>();
    ArrayList <Integer> position = new ArrayList<>();
    ArrayList <String> operation = new ArrayList<>();
    ArrayList <String> expList = new ArrayList<>();

    Calc(String string) {
        expression = string.split(" ");
        makeList();
        distribute();
        sort();
    }

    private void makeList() {
        for (String arr: expression) {
            expList.add(arr);
        }
    }

    private void distribute() {
        for (int i = 0; i<expList.size(); i++ ) {
            switch (expList.get(i)) {
                case "(":
                    ++varPriority;
                    expList.remove(i);
                    --i;
                    break;
                case ")":
                    --varPriority;
                    expList.remove(i);
                    --i;
                    break;
                case "or":
                    operation.add(Operation.OR);
                    priority.add(varPriority);
                    position.add(i);
                    break;
                case "and":
                    operation.add(Operation.AND);
                    priority.add(varPriority);
                    position.add(i);
                    break;
            }
        }
    }

    private void sort() {
        for (int j = 0; j < expList.size() - 1; j++) {
            for (int i = 0; i<(priority.size()-1); i++) {
                Integer tempPriority;
                Integer tempPosition;
                String tempOperation;
                if ((priority.get(i + 1) - priority.get(i)) > 0) {
                    tempPriority = priority.get(i);
                    tempPosition = position.get(i);
                    tempOperation = operation.get(i);
                    priority.set(i, priority.get(i + 1));
                    position.set(i, position.get(i + 1));
                    operation.set(i, operation.get(i + 1));
                    priority.set(i + 1, tempPriority);
                    position.set(i + 1, tempPosition);
                    operation.set(i + 1, tempOperation);
                }
            }
        }
    }

    private void shiftIndexPosition(int i){
        for (int j=i+1; j<position.size();j++){
            if (position.get(i)<position.get(j)) {
                position.set(j, position.get(j)-2);
            }
        }
    }

    public void calculate() {
        for (int i=0; i<operation.size(); i++) {
            switch (operation.get(i)) {
                case "OR":
                    expList.set(position.get(i) - 1,
                            Operation.OR(expList.get(position.get(i) - 1),
                                    expList.get(position.get(i) + 1)));
                    expList.remove((int)position.get(i));
                    expList.remove((int)position.get(i));
                    shiftIndexPosition(i);
                    break;
                case "AND":
                    /*for (String s: expList) {
                        System.out.println(s);
                    }*/
                    expList.set(position.get(i) - 1,
                            Operation.AND(expList.get(position.get(i) - 1),
                                    expList.get(position.get(i) + 1)));
                    expList.remove((int)position.get(i));
                    expList.remove((int)position.get(i));
                    //expList.remove(position.get(i));
                    shiftIndexPosition(i);
                    break;
            }
        }
    }

    public void printResult() {
        for (String s:expList)
        System.out.println(s);
    }
}
