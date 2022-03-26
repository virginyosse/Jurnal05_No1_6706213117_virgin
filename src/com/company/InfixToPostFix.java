package com.company;

public class InfixToPostFix {
    private Stack s;
    private String input = "";
    private String output = "";

    public InfixToPostFix(String in) {
        input = in;
        int stackSize = input.length();
        s = new Stack(stackSize);
    }

    public String doTrans() {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);
                    break;
                case '^':
                    gotOper(ch, 3);
                    break;
                case '(':
                    s.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output = output + ch;
                    break;
            }
        }
        while (!s.isEmpty()) {
            output = output + s.pop();
        }
        System.out.println(output);
        return output;
    }

    public void gotOper(char opThis, int prec1) {
        while (!s.isEmpty()) {
            char opTop = s.pop();
            if (opTop == '(') {
                s.push(opTop);
                break;
            }
            else {
                int prec2;
                if (opTop == '+' || opTop == '-')
                    prec2 = 1;
                else
                    prec2 = 2;
                if (prec2 < prec1) {
                    s.push(opTop);
                    break;
                }
                else
                    output = output + opTop;
            }
        }
        s.push(opThis);
    }

    public void gotParen(char ch){
        while (!s.isEmpty()) {
            char chx = s.pop();
            if (chx == '(')
                break;
            else
                output = output + chx;
        }
    }
}
