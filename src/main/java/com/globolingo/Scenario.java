package com.globolingo;

public class Scenario {

    // Initialize SystemFACADE
    static SystemFACADE sf = new SystemFACADE();

    private static void scenario1() {
        System.out.println("---------SCENARIO 1--------- \n");

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
        System.out.println("Let's start learning, " + sf.getCurrentUser().getUsername());
        sf.startLearning(Language.SPANISH);
        
    }

    /**
     * Helper method for displaying the entries in User.json, using Dataloader.java
     * @param args
     */
    public static void displayJSON() {
        System.out.println("---------SCENARIO 2--------- \n");
        System.out.println("Users from User.json:");
        for (User user : DataLoader.getUsers()) {
            System.out.println(user + "\n");
        }
    }
    
    public static void main(String[] args) {
        scenario1();
        scenario2();
        sf.removeCurrentUser();
    }
}
