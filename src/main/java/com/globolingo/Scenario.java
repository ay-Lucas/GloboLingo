package com.globolingo;

import java.util.ArrayList;

public class Scenario {
    
    private static void scenario1() {
        // Load User, SystemFACADE, and Userlist into memory

        SystemFACADE sf = new SystemFACADE();

        System.out.println("Loaded from User.json via UserList");

        UserList ul = UserList.getInstance();
        
        // Verify Tammy is in the list while Tim is not
        for (User user : ul.getUsers()) {
            System.out.println(user + "\n");
        }

        // Attempt to add Tim a duplicate username
        User testUser1 = new User("ttomacka", "01234567", "Tim", "Tomacka", 0, null, null, null);
        ul.addUser(testUser1);

        // Attempt to add Tim with a unique username
        User testUser2 = new User("ttom", "01234567", "Tim", "Tomacka", 0, null, null, null);
        ul.addUser(testUser2);

        // Verify Tim is saved to the User.json file, and not simply in volatile memory
        System.out.println("Loaded from User.json via DataLoader");
        for (User user : DataLoader.getUsers()) {
            System.out.println(user + "\n");
        }

        // Log Tim in and verify his login boolean is set to true
        sf.login("ttom", "01234567");

        // Verify Tim is saved to the User.json file, and not simply in volatile memory
        System.out.println(" \n Loaded from User.json via DataLoader");
        for (User user : DataLoader.getUsers()) {
            System.out.println(user + "\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("Scenario 1 \n");
        scenario1();
    }
}
