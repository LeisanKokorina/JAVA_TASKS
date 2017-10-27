package ru.itpark;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // макс 150 ответов
        // отлично, все устраивает - 10
        // в целом, все хорошо - 7,5
        // удовл - 5
        // плохо - 2
        Scanner scanner = new Scanner(System.in);
        double count5 = 0.0;
        double count4 = 0.0;
        double count3 = 0.0;
        double count2 = 0.0;
        System.out.println("5. Отл = 10");
        System.out.println("4. Хорошо = 7,5");
        System.out.println("3. Удовл = 5");
        System.out.println("2. Плохо = 2");
        System.out.println("1. Вывести счетчик");
        System.out.println("9. Выход из программы");

        while(true){


            int mark = scanner.nextInt();
            switch (mark){
                case 5:{
                     count5 = count5 + 10;

                }break;

                case 4:{
                    count4 = count4 + 7.5;
                }break;
                case 3: {
                    count3 = count3 + 5;
                }break;

                case 2:{
                    count2 = count2 + 2;
                }break;
                case 1:{
                    System.out.println("Отлично = "+count5);
                    System.out.println("Хорошо = "+count4);
                    System.out.println("Удовл = "+count3);
                    System.out.println("Плохо = "+count2);
                }break;
                case 9 :{
                    System.exit(0);
                }break;


            }
        }

    }
}
