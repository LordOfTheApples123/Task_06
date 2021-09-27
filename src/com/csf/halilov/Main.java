package com.csf.halilov;

import jdk.nashorn.api.scripting.ScriptUtils;

import java.util.Scanner;

public class Main {

    public static void out(String s) {
        System.out.print(s);
    }

    public static void outln(String s) {
        System.out.println(s);
    }

    public static double Progression(int n, double x) {
        if (n == 1) {
            return 1;
        } else return Progression(n - 1, x) / (n - 1) * (n + 1) * (-x);
    }

    public static double Sum(int n, double x) {
        double S = 0;
        for (int i = 1; i <= n; i++) {
            S += Progression(i, x);
        }
        return S;
    }

    public static double SumOfMembersGreaterThanE(int n, double x, double e) {
        double S = 0;
        int i = 1;
        while (Math.abs(Progression(i, x)) > e) {
            S += Progression(i, x);
            i++;
        }
        return S;
    }

    public static double SumOfMembersGreaterThanE10(int n, double x, double e) {
        double S = 0;
        int i = 1;
        while (Math.abs(Progression(i, x)) > e / 10) {
            S += Progression(i, x);
            i++;
        }
        return S;
    }

    public static void main(String[] args) {
        double x, e, a;
        int n;
        Scanner in = new Scanner(System.in);
        out("Введите числа в порядке n, x ,e >> ");
        n = in.nextInt();
        x = in.nextDouble();
        e = in.nextDouble();
        a = Math.pow(1+x, 3);
        a = 1/a;
        outln("");
        outln("Сумма " + n + " членов последовательности = " + Sum(n, x));
        outln("Сумма тех слагаемых, которые по абсолютной величине больше " + e + " = " + SumOfMembersGreaterThanE(n, x, e));
        outln("Сумма тех слагаемых, которые по абсолютной величине больше " + e/10 + " = " + SumOfMembersGreaterThanE10(n, x, e));
        outln("Значение функции с помощью методов Math = " + a);
    }
}
