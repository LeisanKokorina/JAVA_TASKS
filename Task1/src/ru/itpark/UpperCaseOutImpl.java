package ru.itpark;

public class UpperCaseOutImpl implements StringOut {

    @Override
    public String output(String text) {
        return text.toUpperCase();
    }
}
