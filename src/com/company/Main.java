package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan infix : ");
        String input = scan.next();
        String output;
        InfixToPostFix theTrans = new InfixToPostFix(input);
        System.out.print("Postfixnya adalah : ");
        output = theTrans.doTrans();
    }
}
