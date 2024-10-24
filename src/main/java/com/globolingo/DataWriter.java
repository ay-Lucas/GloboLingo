package com.globolingo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * DataWriter is responsible for saving data objects such as User objects to JSON files.
 * This class provides methods to convert Java objects into JSON format and write them
 * to a specified file path. Currently, it supports saving a list of User objects to a file.
 */
public class DataWriter extends DataConstants {

    /*
     * The following commented-out section provides a future implementation
     * of saving a dictionary list of words to a JSON file.
     */
    /* Dictionary functionality for future implementation
    public static boolean saveDictionaryList(ArrayList<Word> wordList) {
        JSONArray jsonWords = new JSONArray();
        for (Word word : wordList) {
            jsonWords.add(getWordJSON(word));
        }
        return writeToFile(jsonWords, DICTIONARY_FILE_PATH);
    }

    private static JSONObject getWordJSON(Word word) {
        JSONObject wordDetails = new JSONObject();
        wordDetails.put("english", word.getEnglish());
        wordDetails.put("translation", word.getTranslation());
        wordDetails.put("subject", word.getSubject());
        return wordDetails;
    }
    */

    /**
     * Converts a list of User objects to a JSON array and saves it to a file.
     * 
     * @param userList The list of User objects to be saved
     * @return true if the user list is successfully saved, false otherwise
     */
    public static boolean saveUserList(ArrayList<User> userList) {
        JSONArray jsonUsers = new JSONArray();
        for (User user : userList) {
            jsonUsers.add(getUserJSON(user)); // Converts each user to JSON format
        }
        return writeToFile(jsonUsers, USER_FILE_PATH); // Writes the JSON array to a file
    }

    /**
     * Converts a User object into a JSONObject that can be written to a file.
     * 
     * @param user The User object to be converted
     * @return A JSONObject representation of the User
     */
    private static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_USERNAME, user.getUsername()); // Adds the username
        userDetails.put(USER_FIRSTNAME, user.getFirstName()); // Adds the first name
        userDetails.put(USER_LASTNAME, user.getLastName()); // Adds the last name
        userDetails.put(USER_PASSWORD, user.getPassword()); // Adds the password
        userDetails.put(USER_LEVEL, user.getLevel()); // Adds the user's level
        userDetails.put(USER_UUID, user.getUUID().toString()); // Adds the UUID (as String)
        userDetails.put(USER_LOGGIN_IN, user.isLoggedIn()); // Adds login status

        // Creates a JSON array for the user's courses
        JSONArray coursesArray = new JSONArray();
        for (Course course : user.getCourseList()) {
            JSONObject courseObj = new JSONObject();
            courseObj.put(USER_COURSES_LANGUAGE, course.getLanguage().getLanguage().toLowerCase()); // Adds course language
            courseObj.put(USER_COURSES_CURRENT_LESSON, 0); // Placeholder for lesson progress
            coursesArray.add(courseObj);
        }
        userDetails.put(USER_COURSES, coursesArray); // Adds the courses array to the user

        // Adds avatar details (if any) to the user object
        addAvatarDetails(userDetails, user);
        return userDetails;
    }

    /**
     * Adds the avatar details of a user (if available) to the user's JSON representation.
     * 
     * @param userDetails The JSONObject representing the user
     * @param user The User whose avatar details are to be added
     */
    private static void addAvatarDetails(JSONObject userDetails, User user) {
        Avatar avatar = user.getAvatar();
        if (avatar != null) {
            JSONObject avatarJSON = new JSONObject();
            avatarJSON.put(USER_AVATAR_NAME, avatar.getName()); // Adds avatar name

            // Creates a JSON array for the user's unlocked avatars
            JSONArray unlockedAvatars = new JSONArray();
            for (Avatar unlockedAvatar : user.getUnlockedAvatars()) {
                unlockedAvatars.add(unlockedAvatar.getName()); // Adds unlocked avatar names
            }
            avatarJSON.put(USER_AVATAR_UNLOCKED, unlockedAvatars); // Adds unlocked avatars array
            userDetails.put(USER_AVATAR, avatarJSON); // Adds the avatar object to the user
        }
    }

    /**
     * Writes a JSONArray to a specified file path in JSON format.
     * 
     * @param jsonArray The JSONArray to be written to the file
     * @param filePath The path of the file where the JSON data should be saved
     * @return true if the file was successfully written, false otherwise
     */
    private static boolean writeToFile(JSONArray jsonArray, String filePath) {
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonArray.toJSONString()); // Writes the JSON array to the file
            file.flush(); // Flushes the stream to ensure data is written
            return true; // Return success
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage()); // Prints error if writing fails
            return false; // Return failure
        }
    }

    /**
     * Main method to demonstrate the saving of user data to a file.
     * 
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        try {
            ArrayList<User> users = DataLoader.getUsers(); // Loads users from the data source
            boolean saveSuccess = saveUserList(users); // Attempts to save the user list
            if(saveSuccess) {
                System.out.println("\nUser data successfully saved to file"); // Success message
            } else {
                System.out.println("\nFailed to save user data to file"); // Failure message
            }
        } catch (Exception e) {
            System.out.println("\nError occurred while saving user data: " + e.getMessage()); // Prints exception message
        }
    }
}