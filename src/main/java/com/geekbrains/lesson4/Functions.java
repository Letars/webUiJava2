package com.geekbrains.lesson4;

import java.util.Scanner;

public class Functions {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Введите значение стороны a=");
        int a=sc.nextInt();

        System.out.println("Введите значение стороны b=");
        int b=sc.nextInt();

        System.out.println("Введите значение стороны c=");
        int c=sc.nextInt();

        if (a<=0 || b<=0 || c<=0) {
            System.out.println("Вы ввели некорректные значения, попробуйте еще раз");
        }
        int d = (a+b+c)/2;
       double triangle= (int) Math.sqrt(d*(d-a)*(d-b)*(d-c));

        System.out.println("Площадь треугольника = " + triangle);

        sc.close();
    }
}
