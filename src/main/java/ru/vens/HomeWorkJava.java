package ru.vens;

public class HomeWorkJava {

    public static void main(String[] args) {
        // 0) Арифметические операции над двумя int
        int a = 9;
        int b = 4;
        double d = 3.5;
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));

        // 1) Арифметические операции между int и double
        double result = a + d * b - a / d;
        System.out.println("a + d * b - a / d = " + result);

        // 2) Логические операции
        System.out.println("a < b: " + (a < b));
        System.out.println("a > b: " + (a > b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));

        // 3) Диапазоны типов данных с плавающей точкой
        System.out.println("Максимальное значение Double = " + Double.MAX_VALUE);
        System.out.println("Минимальное значение Double = " + Double.MIN_VALUE);
        System.out.println("Максимальное значение Float = " + Float.MAX_VALUE);
        System.out.println("Минимальное значение Float = " + Float.MIN_VALUE);

        // 4) Переполнение при арифметической операции
        int maxInt = Integer.MAX_VALUE;
        System.out.println("Максимальное значение Integer = " + maxInt);
        int overflow = maxInt + 1; // переполнение
        System.out.println("Переполнение: maxInt + 1 = " + overflow); // результат будет отрицательным
    }
}
