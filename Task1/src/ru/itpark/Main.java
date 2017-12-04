package ru.itpark;

public class Main {

    public static void main(String[] args) {

        StringOut upper = new UpperCaseOutImpl();
        StringOut lower = new LowerCaseOutImpl();
        StringOut split = new SplitOutImpl();
        StringClass stringClass = new StringClass("hello-world", lower);

        System.out.println(stringClass.result());
    }
}
