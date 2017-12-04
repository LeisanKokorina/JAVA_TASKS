package ru.itpark;

public class LowerCaseOutImpl implements StringOut {

    @Override
    public String output(String text) {
        return text.toLowerCase();
    }
}
