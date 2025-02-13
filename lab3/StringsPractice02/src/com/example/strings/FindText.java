package com.example.strings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindText {

    // Create Pattern
    private Pattern pattern;
    private Matcher m;
    // Create Matcher

    public static void main(String[] args) {
        FindText find = new FindText();
        find.run(args[0], args[1]);
    }

    public void run(String fileName, String inputPattern) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            int c = 1;
            pattern = Pattern.compile(inputPattern);
            while ((line = reader.readLine()) != null) {
                // Generate a matcher based on Pattern
                // Search for text
                // Print results
                m = pattern.matcher(line);

                if(m.find()){
                    System.out.println(" " + c + "  " + line);
                }
                c++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
