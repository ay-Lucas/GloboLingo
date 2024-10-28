package com.globolingo;
import java.util.Scanner;

public class UI  {

    public static String getInput()  {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.next();
        keyboard.close();
        return input;
    }
}
