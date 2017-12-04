package ru.itpark;

import javax.swing.*;
import java.util.Arrays;

public class SplitOutImpl implements StringOut {

    @Override
    public String output(String text) {
        String [] parts = text.split("w");
        String part1 = parts[0];
        String part2 = parts[1];
        return part1 + part2;
    }
}
