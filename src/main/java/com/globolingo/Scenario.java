package com.globolingo;

import java.util.ArrayList;

public class Scenario {
    
    private static void scenario1() {
        System.out.println("Loaded from User.json using UserList");

        UserList ul = UserList.getInstance();
        
        for (User user : ul.getUsers()) {
            System.out.println(user);
            System.out.println();
        }

        User testUser1 = new User("ttomacka", "01234567");
        ul.addUser(testUser1);

        System.out.println("Loaded from User.json using DataLoader");
        for (User user : DataLoader.getUsers()) {
            System.out.println(user);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Scenario 1 \n");
        scenario1();
    }
}
