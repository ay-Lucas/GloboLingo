package com.globolingo;

import java.util.ArrayList;
import java.util.UUID;

/**
 * The UserList class manages a collection of User objects.
 * It implements the Singleton design pattern to ensure only one instance
 * of the user list is created and provides methods to manage users
 * such as adding, editing, removing, and retrieving users.
 */
public class UserList extends DataConstants {

    private static UserList instance;
    private ArrayList<User> users;

    /**
     * Private constructor to initialize the user list.
     * It loads users from the data source using the DataLoader.
     */
    private UserList() {
        users = DataLoader.getUsers();
    }

    /**
     * Gets the singleton instance of the UserList.
     * 
     * @return the singleton instance of UserList
     */
    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    /**
     * Retrieves the list of all users.
     * 
     * @return an ArrayList containing all User objects
     */
    public ArrayList<User> getUsers() {
        return this.users;
    }

    /**
     * Retrieves a user by their username.
     * 
     * @param username the username of the user to retrieve
     * @return the User object if found, null otherwise
     */
    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Retrieves the avatar of a user by their username.
     * 
     * @param username the username of the user whose avatar is to be retrieved
     * @return the Avatar object if the user is found, null otherwise
     */
    public Avatar getAvatar(String username) {
        User user = getUser(username);
        if (user != null) {
            return user.getAvatar();
        }
        return null;
    }

    /**
     * Retrieves a user by their UUID.
     * 
     * @param id the UUID of the user to retrieve
     * @return the User object if found, null otherwise
     */
    public User getUserByUUID(UUID id) {
        for (User user : users) {
            if (user.getUUID().equals(id)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Edits the details of an existing user.
     * 
     * @param user the User object containing updated details
     */
    public void editUser(User user) {
        User existingUser = getUser(user.getUsername());
        if (existingUser != null) {
            existingUser.updateDetails(
                    user.getFirstName(),
                    user.getLastName(),
                    user.getPassword(),
                    user.getLevel(),
                    user.getAvatar(),
                    user.getCourseList());
            saveUsers();
        }
    }

    /**
     * Removes a user from the list by their username.
     * 
     * @param username the username of the user to remove
     * @return true if the user was successfully removed, false otherwise
     */
    public boolean removeUser(String username) {
        User userToRemove = getUser(username);
        if (userToRemove != null) {
            users.remove(userToRemove);
            saveUsers();
            return true;
        }
        return false;
    }

    /**
     * Logs in a user by setting their login status to true.
     * 
     * @param user the User object to log in
     */
    public void logInUser(User user) {
        user.setLoggedIn(true);
        saveUsers();
    }

    /**
     * Logs out a user by setting their login status to false.
     * 
     * @param user the User object to log out
     */
    public void logOutUser(User user) {
        user.setLoggedIn(false);
        saveUsers();
    }

    /**
     * Saves a user by updating their details in the list.
     * 
     * @param user the User object to save
     */
    public void saveUser(User user) {
        int index = users.indexOf(getUser(user.getUsername()));
        if (index != -1) {
            users.set(index, user);
            saveUsers();
        }
    }

    /**
     * Adds a new user to the list.
     * 
     * @param user the User object to add
     * @return true if the user was successfully added, false if the username or
     *         UUID is already taken
     */
    public boolean addUser(User user) {
        for (User i : users) {
            if (i.getUsername().equals(user.getUsername())) {
                System.out.println("Error: username taken. Try Again.");
                return false;
            }
            if (i.getUUID().equals(user.getUUID())) {
                System.out.println("Error: UUID taken. Try Again.");
                return false;
            }
        }
        users.add(user);
        saveUsers();
        return true;
    }

    /**
     * Saves the current list of users to the data source.
     */
    private void saveUsers() {
        DataWriter.saveUserList(users);
    }
}
