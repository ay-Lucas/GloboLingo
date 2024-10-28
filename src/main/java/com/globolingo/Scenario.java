package com.globolingo;

import java.util.ArrayList;

public class Scenario {

    // Initialize SystemFACADE
    static SystemFACADE sf = new SystemFACADE();

    private static void scenario1() {

        System.out.println("Loaded from User.json via UserList");
        
        // Verify Tammy is in the list while Tim is not
        displayJSON();

        // Attempt to add Tim a duplicate username
        sf.createAccount("ttomacka", "012345678", "Tim", "Tomacka");

        // Attempt to add Tim with a unique username
        sf.createAccount("ttom", "012345678", "Tim", "Tomacka");

        // Verify Tim is saved to the User.json file, and not simply in volatile memory
        displayJSON();
    }

    public static void scenario2() {
        // Start Tim's learning session
        sf.createCourse(Language.SPANISH);
        sf.setCurrentCourse(null);
    }

    /**
     * Helper method for displaying the entries in User.json, using Dataloader.java
     * @param args
     */
    public static void displayJSON() {
        System.out.println("Users from User.json:");
        for (User user : DataLoader.getUsers()) {
            System.out.println(user + "\n");
        }
    }
    

    public static void main(String[] args) {
        System.out.println("Scenario 1 \n");
        scenario1();
        System.out.println("Scenario 2 \n");
        scenario2();
    }
}
