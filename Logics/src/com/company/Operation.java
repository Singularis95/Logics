package com.company;

public class Operation {

    public static final String OR = "OR";
    public static final String AND = "AND";
    /*public static final String NOT = "NOT";*/

    public static String OR(String prev, String next) {
        if (prev.equals(next))
            return prev;
        else if ((prev.equals("notX") && next.equals("X")) | (prev.equals("X") && next.equals("notX")))
            return "1";
        else if (prev.equals("0"))
            return next;
        else if (next.equals("0"))
            return prev;
        else if (prev.equals("1") | next.equals("1"))
            return "1";
        else return "EXCEPT(or)";
    }

    public static String AND(String prev, String next) {
        if (prev.equals(next))
            return prev;
        else if ((prev.equals("notX") && next.equals("X")) | (prev.equals("X") && next.equals("notX")))
            return "0";
        else if (prev.equals("1"))
            return next;
        else if (next.equals("1"))
            return prev;
        else if (prev.equals("0") | next.equals("0"))
            return "0";
        else return "EXCEPT(and)";
    }

    /*public static String NOT(String element) {
        if (element.equals("X"))
            return "notX";
        if (element.equals("notX"))
            return "X";
        if (element.equals("1"))
            return "0";
        if (element.equals("0"))
            return "1";
        else return "EXCEPT(not)";
    }*/

}
