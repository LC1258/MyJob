package com.lwj.codeexamination.mihayou;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            String[] str = s.split(" ");
            String s1 = str[0];
            String s2 = str[1];
            String s3 = str[2];
            String[] s1s = s1.split("/");
            String[] s3s = s3.split("/");
            int a = Integer.valueOf(s1s[0]);
            int b = Integer.valueOf(s1s[1]);
            int c = Integer.valueOf(s3s[0]);
            int d = Integer.valueOf(s3s[1]);
            char operate = s2.toCharArray()[0];
            Operate r1 = new Operate(a, b);
            Operate r2 = new Operate(c, d);
            if (operate == '+') {
                Operate res = r1.add(r2);
                int x = res.getNum();
                int y = res.getDen();
                if (x % y == 0) {
                    System.out.println(x / y);
                } else {
                    System.out.println(x + "/" + y);
                }
            } else if (operate == '-') {
                Operate res = r1.sub(r2);
                int x = res.getNum();
                int y = res.getDen();
                if (x % y == 0) {
                    System.out.println(x / y);
                } else {
                    System.out.println(x + "/" + y);
                }
            } else if (operate == '*') {
                Operate res = r1.muti(r2);
                int x = res.getNum();
                int y = res.getDen();
                if (x % y == 0) {
                    System.out.println(x / y);
                } else {
                    System.out.println(x + "/" + y);
                }
            } else if (operate == '/') {
                Operate res = r1.div(r2);
                int x = res.getNum();
                int y = res.getDen();
                if (x % y == 0) {
                    System.out.println(x / y);
                } else {
                    System.out.println(x + "/" + y);
                }
            }
        }
        in.close();
    }
}

class Operate{
    int num;
    int den;
    Operate(int a, int b) {
        if (a == 0) {
            num = 0;
            den = 1;
        } else {
            setNumandDen(a, b);
        }
    }

    public void setNumandDen(int a, int b) {
        int c = gcd(Math.abs(a), Math.abs(b));
        num = a/ c;
        den = b / c;
        if (num < 0 && den < 0) {
            num = -num;
            den = -den;
        }
    }
    public int getNum(){
        return num;
    }
    public int getDen(){
        return den;
    }
    public int gcd(int a, int b) {
        if (a < b) {
            int c = a;
            a = b;
            b = c;
        }
        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }

    public Operate add(Operate r) {
        int a = r.getNum();
        int b = r.getDen();
        int newNum = num * b + den * a;
        int newDen = den * b;
        Operate result = new Operate(newNum, newDen);
        return result;
    }
    public Operate sub(Operate r) {
        int a = r.getNum();
        int b = r.getDen();
        int newNum = num * b - den * a;
        int newDen = den * b;
        Operate result = new Operate(newNum, newDen);
        return result;
    }
    public Operate muti(Operate r) {
        int a = r.getNum();
        int b = r.getDen();
        int newNum = num * a;
        int newDen = den * b;
        Operate result = new Operate(newNum, newDen);
        return result;
    }
    public Operate div(Operate r) {
        int a = r.getNum();
        int b = r.getDen();
        int newNum = num * b + den * a;
        int newDen = den * b;
        Operate result = new Operate(newNum, newDen);
        return result;
    }
}
