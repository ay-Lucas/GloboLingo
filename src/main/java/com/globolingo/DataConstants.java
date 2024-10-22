package com.globolingo;

public class DataConstants {
    // File paths
    protected static final String LANGUAGE_FILE_PATH = "json/Language.json";

    // JSON keys for Progress
    protected static final String PROGRESS_COMPLETED_SECTIONS = "completedSections";
    protected static final String PROGRESS_COMPLETED_LESSONS = "completedLessons";
    protected static final String PROGRESS_NEXT_LOOT_CRATE_AT = "nextLootCrateAt";
    protected static final String PROGRESS_COURSE = "course";

    // JSON keys for Course
    protected static final String COURSE_NAME = "courseName";
    protected static final String COURSE_LANGUAGE = "language";
    protected static final String COURSE_COMPLETED_SECTIONS = "completedSections";

    // JSON keys for Section (used inside Progress and Course)
    protected static final String SECTION_TITLE = "title";
    protected static final String SECTION_SUBJECT = "subject";

    // JSON keys for User
    protected static final String USER_FILE_PATH = "json/User.json";
    protected static final String USER_USERNAME = "username";
    protected static final String USER_PASSWORD = "password";
    protected static final String USER_UUID = "UUID";
    protected static final String USER_FIRSTNAME = "firstName";
    protected static final String USER_LASTNAME = "lastName";
    protected static final String USER_LOGGIN_IN = "loggedIn";
    protected static final String USER_LEVEL = "level";
    protected static final String USER_AVATAR = "avatar";
    protected static final String USER_AVATAR_NAME = "name";
    protected static final String USER_AVATAR_UNLOCKED = "unlocked";
    protected static final String USER_PROGRESS = "progress";
    protected static final String USER_PROGRESS_COMPLETED_SECTIONS = "completedSections";
    protected static final String USER_PROGRESS_COMPLETED_LESSONS = "completedLessons";
    protected static final String USER_PROGRESS_NEXT_LOOT_CRATE_AT = "nextLootCrateAt";
}
