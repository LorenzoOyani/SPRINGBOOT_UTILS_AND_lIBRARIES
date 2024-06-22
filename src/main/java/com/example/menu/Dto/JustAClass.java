package com.example.menu.Dto;

import java.util.function.BiFunction;

public class JustAClass {

    private static int a;
    private static int b;

    JustAClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public JustAClass(Object o, Object o1) {
        if (o instanceof Integer && o1 instanceof Integer) {
            this.a = (int) o;
            this.b = (int) o1;

        } else {
            throw new IllegalArgumentException("error!");
        }
    }

    @Override
    public String toString() {
        return STR."JustAClass{a=\{a}, b=\{b}\{'}'}";
    }

    public static void main(String[] args) {
        BiFunction<Integer, Integer, JustAClass> function = JustAClass::new;

        JustAClass justAClass = function.apply(10 ,20);
        System.out.println(justAClass);
    }
}
