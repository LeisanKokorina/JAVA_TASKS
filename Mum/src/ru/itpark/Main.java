package ru.itpark;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // отлично, все устраивает - 10
        // в целом, все хорошо - 7,5
        // удовл - 5
        // плохо - 2
        Scanner scanner = new Scanner(System.in);
        double sum5 = 0.0;
        double sum4 = 0.0;
        double sum3 = 0.0;
        double sum2 = 0.0;
        double sum1 = 0.0;
        int yes = 0;
        int not = 0;
        System.out.println("5. Отл = 10");
        System.out.println("4. Хорошо = 7,5");
        System.out.println("3. Удовл = 5");
        System.out.println("2. Плохо = 2,5");
        System.out.println("1. Неуд = 0");
        System.out.println("6. ДА = 2");
        System.out.println("7. НЕТ = 0");
        System.out.println("8. Вывести суммы");
        System.out.println("9. Выход из программы");

        while(true){


            int mark = scanner.nextInt();
            switch (mark){
                case 5:{
                     sum5 = sum5 + 10;

                }break;

                case 4:{
                    sum4 = sum4 + 7.5;
                }break;
                case 3: {
                    sum3 = sum3 + 5;
                }break;

                case 2:{
                    sum2 = sum2 + 2.5;
                }break;
                case 1:{
                    sum1 = 0;

                }break;
                case 6:{
                    yes = yes + 2;
                }break;
                case 7: {
                    not =  0;
                }break;
                case 8:{
                    System.out.println("Отлично = "+sum5);
                    System.out.println("Хорошо = "+sum4);
                    System.out.println("Удовл = "+sum3);
                    System.out.println("Плохо = "+sum2);
                    System.out.println("Неуд = "+sum1);
                    double summa = sum1+sum2+sum3+sum4+sum5;
                    int yesnot = yes + not;
                    System.out.println("Общая сумма по пункту анкеты = "+summa);
                    System.out.println("Да/Нет = "+ yesnot);
                }break;
                case 9 :{
                    System.exit(0);
                }break;
            }
        }
    }
}
