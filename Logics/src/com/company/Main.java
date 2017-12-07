package com.company;

public class Main {

    public static void main(String[] args) {
        String s = new String("( ( ( ( ( X or notX ) and ( 0 or 1 ) ) and notX ) or X ) or 0 ) or X");
        //важно все элементы разделять пробелами, операции вводить строчными буквами
        Calc c = new Calc(s);
        c.calculate();
        c.printResult();
    }
}
