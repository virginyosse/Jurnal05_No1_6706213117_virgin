package com.company;

public class Stack {

    private int top;
    private int size;
    private char[] arr;

    public Stack(int max) {
        size = max;
        top = -1;
        arr = new char[size];

    }
    public void push(char num) {
        arr[++top] = num;
    }
    public char pop() {
        return arr[top--];
    }
    public char peek() {
        return arr[top];
    }
    public boolean isEmpty() {
        return top == -1;
    }
}
