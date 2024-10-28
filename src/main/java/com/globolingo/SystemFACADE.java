package com.globolingo;

import java.util.ArrayList;

public class SystemFACADE {
    private User user;
    private UserList userList;
    private User currentUser; 
    private Course currentCourse;
    private Lesson currentLesson;
    private Question currentQuestion;
    private AvatarManager avatarManager;

    public SystemFACADE() {
        userList = UserList.getInstance();
        avatarManager = new AvatarManager();
    }

    public void createAccount(String username, String password, String firstName, String lastName) {
        User newUser = new User(username, password, firstName, lastName, 0, null, null, null);
        if(userList.addUser(newUser)) {
            login(username, password);
        }
    }

    public boolean login(String username, String password) {
        User user = userList.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println(" \n Hello, " + user.getFirstName() + "\n");
            currentUser = user;
            currentUser.setLoggedIn(true);
            userList.saveUser(currentUser);
            return true;
        }
        return false;
    }

    public void logout() {
        if (currentUser != null) {
            userList.logOutUser(currentUser);
            currentUser = null;
            currentCourse = null;
            currentLesson = null;
            currentQuestion = null;
        }
    }

    public void startLearning(Language language) {
        if (currentUser != null) {
            Course newCourse = new Course(language, currentUser, currentUser.getLevel());
            currentUser.addCourse(newCourse);
            userList.saveUser(currentUser);
            this.currentCourse = newCourse;
        }
    }


    public void addCompletedLesson() {
        currentCourse.incrementCompletedLessons();
        updateUserLevel();
        userList.saveUser(currentUser);
    }

    public void updateUserLevel() {
        int completedLessons = currentCourse.getCompletedLessons();
        int newLevel = completedLessons / 10 + 1;
        currentUser.setLevel(newLevel);
        userList.saveUser(currentUser);
    }

    public void setUserAvatar(String avatarName) {
        Avatar avatar = avatarManager.getAvatar(avatarName);
        if (avatar != null) {
            currentUser.setAvatar(avatar);
            userList.saveUser(currentUser);
        }
    }

    public void unlockAvatar(String avatarName) {
        Avatar avatar = avatarManager.getAvatar(avatarName);
        if (avatar != null) {
            currentUser.addUnlockedAvatar(avatar);
            userList.saveUser(currentUser);
        }
    }

    public void removeCurrentUser() {
        userList.removeUser(currentUser.getUsername());
    }

    // Getters
    public User getCurrentUser() { return currentUser; }
    public Course getCurrentCourse() { return currentCourse; }
    public Lesson getCurrentLesson() { return currentLesson; }
    public Question getCurrentQuestion() { return currentQuestion; }
    public Avatar getUserAvatar() { return userList.getAvatar(currentUser.getUsername()); }
    public ArrayList<Avatar> getUnlockedAvatars() { return currentUser.getUnlockedAvatars(); }
    public ArrayList<Course> getUserCourses() { return currentUser.getCourseList(); }
}