package ru.itpark;

import java.util.Arrays;

public class StringClass {
    private String line;
    private StringOut stringOut;

    public StringClass(String line, StringOut stringOut) {
        this.line = line;
        this.stringOut = stringOut;
    }

    public String getLine() {  //меняет пары символов местами
        char[] charArray = line.toCharArray();
        for (int i = 0; i < charArray.length-1; i++) {
            if (i % 2 == 0) {
                char temp = charArray[i];
                charArray[i] = charArray[i + 1];
                charArray[i + 1] = temp;
            }
        }

        return Arrays.toString(charArray).replace(",","");
    }


    public String result(){
        return "Line= " + line +'\n'+  "SwapLine= "+ getLine() + '\n'+ "result= " + stringOut.output(getLine());
    }
}
