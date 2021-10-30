package ru.arizara.password;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPassword {

    private static final int LENGHT = 6;
    // регулярные выражения
    private static final String REGEX_SYMBOL = "\\W";
    private static final String REGEX_DIGIT = "\\d";
    private static final String REGEX_LETTER = "\\D";
    private static final String REGEX_LOW_LETTER = "[a-z]";
    private static final String REGEX_UP_LETTER = "[A-Z]";


    public static boolean stringLenght(String str){
        if (str.length() >= LENGHT){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean invalidSymbol(String str){
        Pattern pattern = Pattern.compile(REGEX_SYMBOL);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean containsDigit(String str){
        Pattern pattern = Pattern.compile(REGEX_DIGIT);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean containsLetter(String str){
        Pattern pattern = Pattern.compile(REGEX_LETTER);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean containsLowLetter(String str){
        Pattern pattern = Pattern.compile(REGEX_LOW_LETTER);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean containsUpLetter(String str){
        Pattern pattern = Pattern.compile(REGEX_UP_LETTER);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()){
            return true;
        }
        else{
            return false;
        }
    }
}
