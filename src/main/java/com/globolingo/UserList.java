package com.globolingo;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * UserList is a singleton class that manages a list of User objects.
 * It provides methods to add, retrieve, and manipulate user data.
 * The users are initially loaded from a JSON file upon instantiation.
 */
public class UserList {
    private ArrayList<User> users;
    private static UserList instance;

    /**
     * Private constructor to prevent external instantiation.
     * Initializes the list of users and loads them from the JSON file.
     */
    private UserList() {
        users = new ArrayList<>();
        loadUsersFromJSON();
    }

    /**
     * Retrieves the singleton instance of UserList.
     * 
     * @return the singleton instance of UserList.
     */
    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    /**
     * Adds a new user to the list with the provided details.
     * 
     * @param username the username of the new user.
     * @param firstName the first name of the new user.
     * @param lastName the last name of the new user.
     * @param password the password of the new user.
     * @return the newly created User object.
     */
    public User addUser(String username, String firstName, String lastName, String password) {
        User newUser = new User(username, password);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        users.add(newUser);
        return newUser;
    }

    /**
     * Retrieves the list of all users.
     * 
     * @return an ArrayList containing all User objects.
     */
    public ArrayList<User> getUsers() {
        return this.users;
    }

    /**
     * Searches for a user by their username.
     * 
     * @param username the username to search for.
     * @return the User object if found, otherwise null.
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
     * Searches for a user by their UUID.
     * 
     * @param id the UUID to search for.
     * @return the User object if found, otherwise null.
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
     * @param user the user to be edited.
     */
    public void editUser(User user) {
        User existingUser = getUser(user.getUsername());
        if (existingUser != null) {
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setPassword(user.getPassword());
            existingUser.setLevel(user.getLevel());
            existingUser.setAvatar(user.getAvatar());
            existingUser.setCourse(user.getCourse());
            saveUser(existingUser);
        }
    }

    /**
     * Logs out the specified user.
     * 
     * @param user the user to be logged out.
     */
    public void logOutUser(User user) {
        user.setCourse(null);
        System.out.println("User " + user.getUsername() + " has been logged out.");
    }

    /**
     * Saves the specified user's details.
     * 
     * @param user the user whose details are to be saved.
     */
    public void saveUser(User user) {
        int index = users.indexOf(getUser(user.getUsername()));
        if (index != -1) {
            users.set(index, user);
        }
        System.out.println("User " + user.getUsername() + " has been saved.");
    }

    /**
     * Adds an existing User object to the list.
     * 
     * @param user the User object to add.
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Loads users from a JSON file and adds them to the user list.
     * Each user is created with the details provided in the JSON file.
     */
    private void loadUsersFromJSON() {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("json/User.json")) {
            JSONArray userArray = (JSONArray) parser.parse(reader);
            for (Object obj : userArray) {
                JSONObject userJson = (JSONObject) obj;
                User user = new User(
                    (String) userJson.get("username"),
                    (String) userJson.get("password"),
                    UUID.fromString((String) userJson.get("UUID"))
                );
                user.setFirstName((String) userJson.get("firstName"));
                user.setLastName((String) userJson.get("lastName"));
                user.setLevel(((Long) userJson.get("level")).intValue());
                addUser(user);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
