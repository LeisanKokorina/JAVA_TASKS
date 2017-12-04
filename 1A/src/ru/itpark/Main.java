package ru.itpark;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextInt();
        long n = sc.nextInt();
        long a = sc.nextInt();
        System.out.println(m%a);
        System.out.println((int)Math.ceil(m/a + m%a) * (int)Math.ceil(n/a + n%a));


    }
}
