package com.globolingo;

import java.util.ArrayList;
import java.util.UUID;

public class UserList extends DataConstants {
    private ArrayList<User> users;
    private static UserList instance;

    private UserList() {
        users = DataLoader.getUsers();
    }

    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public Avatar getAvatar(String username) {
        User user = getUser(username);
        if (user != null) {
            return user.getAvatar();
        }
        return null;
    }

    public User getUserByUUID(UUID id) {
        for (User user : users) {
            if (user.getUUID().equals(id)) {
                return user;
            }
        }
        return null;
    }

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

    public boolean removeUser(String username) {
        User userToRemove = getUser(username);
        if (userToRemove != null) {
            users.remove(userToRemove);
            saveUsers();
            return true;
        }
        return false;
    }

    public void logOutUser(User user) {
        user.setLoggedIn(false);
        saveUsers();
    }

    public void saveUser(User user) {
        int index = users.indexOf(getUser(user.getUsername()));
        if (index != -1) {
            users.set(index, user);
            saveUsers();
        }
    }

    public void addUser(User user) {
        users.add(user);
        saveUsers();
    }

    private void saveUsers() {
        DataWriter.saveUserList(users);
    }
}
