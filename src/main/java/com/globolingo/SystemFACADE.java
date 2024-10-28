package com.globolingo;

import java.util.ArrayList;

/**
 * The SystemFACADE class serves as an interface between the user and the
 * underlying system components. It provides methods for account management,
 * user login/logout, course management, and avatar handling.
 */
public class SystemFACADE {
    private UserList userList;
    private User currentUser;
    private Course currentCourse;
    private Lesson currentLesson;
    private Question currentQuestion;
    private AvatarManager avatarManager;

    /**
     * Constructs a new SystemFACADE instance, initializing the user list and avatar
     * manager.
     */
    public SystemFACADE() {
        userList = UserList.getInstance();
        avatarManager = new AvatarManager();
    }

    /**
     * Creates a new user account with the provided details and logs the user in.
     * 
     * @param username  the username for the new account
     * @param password  the password for the new account
     * @param firstName the first name of the user
     * @param lastName  the last name of the user
     */
    public void createAccount(String username, String password, String firstName, String lastName) {
        User newUser = new User(username, password, firstName, lastName, 0, null, null, null);
        if (userList.addUser(newUser)) {
            login(username, password);
        }
    }

    /**
     * Logs the user in with the provided credentials.
     * 
     * @param username the username of the user
     * @param password the password of the user
     * @return true if login is successful, false otherwise
     */
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

    /**
     * Logs out the current user, resetting their session data.
     */
    public void logout() {
        if (currentUser != null) {
            userList.logOutUser(currentUser);
            currentUser = null;
            currentCourse = null;
            currentLesson = null;
            currentQuestion = null;
        }
    }

    /**
     * Starts a new learning course for the current user in the specified language.
     * 
     * @param language the Language object representing the language to learn
     */
    public void startLearning(Language language) {
        if (currentUser != null) {
            Course newCourse = new Course(language, currentUser, currentUser.getLevel());
            currentUser.addCourse(newCourse);
            currentUser.setLevel(currentUser.getLevel() + 1);
            userList.saveUser(currentUser);
            this.currentCourse = newCourse;
            this.currentCourse.doLesson();
        }
    }

    /**
     * Continues the current learning session for the user.
     */
    public void continueLearning() {
        if (currentUser != null || this.currentCourse != null) {
            currentUser.setLevel(currentUser.getLevel() + 1);
            this.currentCourse.doLesson();
        }
    }

    /**
     * Increments the count of completed lessons for the current course and updates
     * user level.
     */
    public void addCompletedLesson() {
        currentCourse.incrementCompletedLessons();
        updateUserLevel();
        userList.saveUser(currentUser);
    }

    /**
     * Updates the user's level based on the number of completed lessons.
     */
    public void updateUserLevel() {
        int completedLessons = currentCourse.getCompletedLessons();
        int newLevel = completedLessons / 10 + 1;
        currentUser.setLevel(newLevel);
        userList.saveUser(currentUser);
    }

    /**
     * Sets the current user's avatar to the specified avatar name.
     * 
     * @param avatarName the name of the avatar to set
     */
    public void setUserAvatar(String avatarName) {
        Avatar avatar = avatarManager.getAvatar(avatarName);
        if (avatar != null) {
            currentUser.setAvatar(avatar);
            userList.saveUser(currentUser);
        }
    }

    /**
     * Unlocks the specified avatar for the current user.
     * 
     * @param avatarName the name of the avatar to unlock
     */
    public void unlockAvatar(String avatarName) {
        Avatar avatar = avatarManager.getAvatar(avatarName);
        if (avatar != null) {
            currentUser.addUnlockedAvatar(avatar);
            userList.saveUser(currentUser);
        }
    }

    /**
     * Removes the current user from the user list.
     */
    public void removeCurrentUser() {
        userList.removeUser(currentUser.getUsername());
    }

    // Getters

    /**
     * Retrieves the currently logged-in user.
     * 
     * @return the User object representing the current user
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Retrieves the current course the user is enrolled in.
     * 
     * @return the Course object representing the current course
     */
    public Course getCurrentCourse() {
        return currentCourse;
    }

    /**
     * Retrieves the current lesson in the user's course.
     * 
     * @return the Lesson object representing the current lesson
     */
    public Lesson getCurrentLesson() {
        return currentLesson;
    }

    /**
     * Retrieves the current question in the user's lesson.
     * 
     * @return the Question object representing the current question
     */
    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    /**
     * Retrieves the current user's avatar.
     * 
     * @return the Avatar object representing the current user's avatar
     */
    public Avatar getUserAvatar() {
        return userList.getAvatar(currentUser.getUsername());
    }

    /**
     * Retrieves the list of avatars unlocked by the current user.
     * 
     * @return an ArrayList containing the unlocked Avatar objects
     */
    public ArrayList<Avatar> getUnlockedAvatars() {
        return currentUser.getUnlockedAvatars();
    }

    /**
     * Retrieves the list of courses enrolled by the current user.
     * 
     * @return an ArrayList containing the Course objects
     */
    public ArrayList<Course> getUserCourses() {
        return currentUser.getCourseList();
    }
}
