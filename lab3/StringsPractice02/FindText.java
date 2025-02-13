package StringsPractice02;

import java.io.*;
import java.util.regex.*;

public class FindText {
    private Pattern pattern;
    private Matcher m;

    public void searchFile(String filename, String regex){
        pattern = Pattern.compile(regex);

        
    }

    public static void main(String[] args){
        if(args.length < 2){
            System.out.println("Usage: java FindText <filename> <regex>");
        }
        FindText finder = new FindText();
        finder.searchFile(args[0], args[1]);
    }
}
