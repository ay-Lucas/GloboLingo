package com.globolingo;
import java.util.Scanner;

public class UI  {
    private static Scanner keyboard;

    public UI()  {
        Scanner keyboard = new Scanner(System.in);
    }

    public static String getInput()  {
        return keyboard.nextLine();
    }
}
