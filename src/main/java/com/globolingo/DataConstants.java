package com.globolingo;

public class DataConstants {

    // File paths
    public static final String USER_FILE_NAME = "json/User.json";
    public static final String LANGUAGE_FILE_NAME = "json/Language.json";

    // JSON keys for User
    public static final String USER_USERNAME = "username";
    public static final String USER_FIRST_NAME = "firstName";
    public static final String USER_LAST_NAME = "lastName";
    public static final String USER_PASSWORD = "password";
    public static final String USER_LEVEL = "level";
    public static final String USER_UUID = "UUID";
    public static final String USER_AVATAR = "avatar";
    public static final String USER_UNLOCKED_AVATARS = "unlocked";

    // JSON keys for Progress
    public static final String PROGRESS_COMPLETED_SECTIONS = "completedSections";
    public static final String PROGRESS_COMPLETED_LESSONS = "completedLessons";
    public static final String PROGRESS_NEXT_LOOT_CRATE_AT = "nextLootCrateAt";
    public static final String PROGRESS_COURSE = "course";

    // JSON keys for Course
    public static final String COURSE_NAME = "courseName";
    public static final String COURSE_LANGUAGE = "language";
    public static final String COURSE_COMPLETED_SECTIONS = "completedSections";

    // JSON keys for Section (used inside Progress and Course)
    public static final String SECTION_TITLE = "title";
    public static final String SECTION_SUBJECT = "subject";
}
