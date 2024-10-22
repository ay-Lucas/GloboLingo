package com.globolingo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

/**
 * A User
 * 
 * @author Lucas
 */
public class User {
    private String username;
    private String firstName = "Globo";
    private String lastName = "Linguist";
    private String password;
    private int level;
    private Avatar avatar;
    private ArrayList<Avatar> unlockedAvatars;
    private ArrayList<Course> courseList;
    private Progress progress;
    private UUID uuid;
    private boolean loggedIn;

    private final static int MIN_PASSWORD_LENGTH = 8;
    private final static int MAX_PASSWORD_LENGTH = 64;
    private final static int MIN_USERNAME_LENGTH = 4;
    private final static int MAX_USERNAME_LENGTH = 64;

    /**
     *
     * Creates a new instance of User
     * 
     * @param username
     * @param firstName
     * @param lastName
     */
    public User(String username, String firstName, String lastName) {
        setUsername(username);
        setFirstName(firstName);
        setLastName(lastName);
        unlockedAvatars = new ArrayList<>();
        courseList = new ArrayList<>();
        courseList.add(new Course(Language.SPANISH, this));
    }

    /**
     * Creates a new instance of User
     * 
     * @param username
     * @param password
     */
    public User(String username, String password) {
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        unlockedAvatars = new ArrayList<>();
        courseList.add(new Course(Language.SPANISH, this));
    }

    /**
     * Creates a new instance of User
     * 
     * @param username
     * @param password
     * @param uuid
     */
    public User(String username, String password, String firstName, String lastname, UUID uuid, int level,
            Avatar avatar, ArrayList<Avatar> unlockedAvatars) {
        setUsername(username);
        setPassword(password);
        this.firstName = firstName;
        this.lastName = lastname;
        this.level = level;
        this.uuid = uuid;
        this.avatar = avatar;
        this.unlockedAvatars = unlockedAvatars;
        this.courseList = new ArrayList<>();
    }

    // Getters

    /**
     * Gets User's Progress
     * 
     * @return Progress
     */
    public Progress getProgress() {
        return this.progress;
    }

    /**
     * Gets User's username
     * 
     * @return
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Gets User's avatar
     * 
     * @return
     */
    public Avatar getAvatar() {
        return this.avatar;
    }

    /**
     * Gets User's current course
     * 
     * @return
     */
    public ArrayList<Course> getCourse() {
        return this.courseList;
    }

    /**
     * Gets User's first name
     * 
     * @return First Name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Gets User's last name
     * 
     * @return Last Name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Gets User's password
     * 
     * @return Password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Gets User's level
     * 
     * @return Level
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * Gets User's UUID
     * 
     * @return UUID
     */
    public UUID getUUID() {
        return this.uuid;
    }

    // Setters

    /**
     * Sets level
     * 
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Sets course
     * 
     * @param course
     */
    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    /**
     * Sets username.
     * Must be between `MIN_USERNAME_LENGTH` and MAX_USERNAME_LENGTH.
     * Throws Error if username is invalid because it can't be null
     * 
     * @param username
     */
    public void setUsername(String username) {
        if (username.length() < MIN_USERNAME_LENGTH || username.length() > MAX_USERNAME_LENGTH) {
            throw new Error("Invalid username length\n" + "Must be " + MIN_USERNAME_LENGTH + " – "
                    + MAX_USERNAME_LENGTH + " characters long");
        } else {
            this.username = username;
        }
    }

    /**
     * Sets password.
     * Must be between MIN_PASSWORD_LENGTH and MAX_PASSWORD_LENGTH.
     * Throws Error if password is invalid because it can't be null
     * 
     * @param password
     */
    public void setPassword(String password) {
        if (password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            throw new Error("Invalid password length\n" + "Must be " + MIN_PASSWORD_LENGTH + " – "
                    + MAX_PASSWORD_LENGTH + " characters long");
        } else {
            this.password = password;
        }
    }

    /**
     * Sets avatar
     * 
     * @param avatar
     */
    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    /**
     * Sets first name.
     * Cannot be empty.
     * 
     * @param firstName
     */
    public void setFirstName(String firstName) {
        if (firstName.isBlank())
            System.out.println("First name cannot be empty");
        else
            this.firstName = firstName;
    }

    /**
     * Sets last name.
     * Cannot be empty.
     * 
     * @param lastName
     */
    public void setLastName(String lastName) {
        if (lastName.isBlank())
            System.out.println("Last name cannot be empty");
        else
            this.lastName = lastName;
    }

    /**
     * Sets uuid
     * 
     * @param uuid
     */
    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Gets an ArrayList of Avatars
     * 
     * @return ArrayList of Avatars
     */
    public ArrayList<Avatar> getUnlockedAvatars() {
        return unlockedAvatars;
    }

    /**
     * Add an avatar to the User's unlockedAvatars
     * 
     * @param avatar
     */
    public void addUnlockedAvatar(Avatar avatar) {
        unlockedAvatars.add(avatar);
    }

    public void addCourse(Course course) {
        courseList.add(course);
    }

    public void removeCourse(Course course) {
        courseList.remove(course);
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    /**
     * Updates all user details at once.
     * 
     * @param firstName new first name
     * @param lastName  new last name
     * @param password  new password
     * @param level     new level
     * @param avatar    new avatar
     * @param course    new course
     */
    public void updateDetails(String firstName, String lastName, String password, int level, Avatar avatar,
            ArrayList<Course> courseList) {
        setFirstName(firstName);
        setLastName(lastName);
        setPassword(password);
        setLevel(level);
        setAvatar(avatar);
        setCourseList(courseList);
    }

    public String toString() {
        String unlockedAvatarsStr = "";
        for (Avatar avatar : unlockedAvatars) {
            unlockedAvatarsStr += avatar.getName() + " ";

        }
        String courseListStr = "";
        for (Course course : courseList) {
            courseListStr += course.getLanguage().getLanguage() + " ";
        }
        return "Username: " + this.username + "\nFirstname:" + this.firstName + "\nLast Name: " + this.lastName
                + "\nAvatar Name: "
                + this.avatar.getName() + "\nUnlocked Avatars: " + unlockedAvatarsStr + "\nCourses: " + courseListStr
                + "\nPassword: "
                + this.password + "\nLevel: " + this.level + "\nID: " + this.uuid;
    }
}
