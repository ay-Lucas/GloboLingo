package com.globolingo;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * The DataLoader class is responsible for loading user, progress, language, and gamified information
 * from JSON files and displaying it in a readable format.
 */
public class DataLoader {
    
    /**
     * Retrieves the singleton instance of UserList.
     *
     * @return the instance of UserList
     */
    public static UserList getUserList() {
        return UserList.getInstance();
    }

    /**
     * Retrieves the singleton instance of ProgressList.
     *
     * @return the instance of ProgressList
     */
    public static ProgressList getProgressList() {
        return ProgressList.getInstance();
    }

    /**
     * The main method that initiates the loading and displaying of information.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        loadAndDisplayUserInfo();
        loadAndDisplayProgressInfo();
        loadAndDisplayLanguageInfo();
        loadAndDisplayGamifiedInfo();
    }

    /**
     * Loads user information from the User.json file and displays it in the console.
     */
    private static void loadAndDisplayUserInfo() {
        System.out.println("User Information:");
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("json/User.json")) {
            JSONArray userArray = (JSONArray) parser.parse(reader);
            for (Object obj : userArray) {
                JSONObject userJson = (JSONObject) obj;
                System.out.println("Username: " + userJson.get("username"));
                System.out.println("Name: " + userJson.get("firstName") + " " + userJson.get("lastName"));
                System.out.println("Password: " + userJson.get("password"));
                System.out.println("Level: " + userJson.get("level"));
                System.out.println("UUID: " + userJson.get("UUID"));
                System.out.println("Completed Sections: " + userJson.get("completedSections"));
                System.out.println("Completed Lessons: " + userJson.get("completedLessons"));
                System.out.println("Next Loot Crate At: " + userJson.get("nextLootCrateAt"));
                System.out.println("Logged In: " + userJson.getOrDefault("LoggedIn", false));
                System.out.println("--------------------");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads progress information from the User.json file and displays it in the console.
     */
    private static void loadAndDisplayProgressInfo() {
        System.out.println("\nProgress Information:");
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("json/User.json")) {
            JSONArray userArray = (JSONArray) parser.parse(reader);
            for (Object obj : userArray) {
                JSONObject userJson = (JSONObject) obj;
                System.out.println("User: " + userJson.get("username"));
                System.out.println("Completed Sections: " + userJson.get("completedSections"));
                System.out.println("Completed Lessons: " + userJson.get("completedLessons"));
                System.out.println("Next Loot Crate At: " + userJson.get("nextLootCrateAt"));
                System.out.println("--------------------");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads language information from the Language.json file and displays it in the console.
     */
    private static void loadAndDisplayLanguageInfo() {
        System.out.println("\nLanguage Information:");
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("json/Language.json")) {
            JSONArray languageArray = (JSONArray) parser.parse(reader);
            for (Object obj : languageArray) {
                JSONObject languageJson = (JSONObject) obj;
                System.out.println("Word: " + languageJson.get("word"));
                System.out.println("Type: " + languageJson.get("type"));
                System.out.println("Options: " + languageJson.getOrDefault("options", "N/A"));
                System.out.println("Answer Index: " + languageJson.getOrDefault("answerIndex", "N/A"));
                System.out.println("Prompt: " + languageJson.get("prompt"));
                System.out.println("Answer: " + languageJson.get("answer"));
                System.out.println("Is Correct: " + languageJson.get("isCorrect"));
                System.out.println("Get Answer: " + languageJson.get("getAnswer"));
                System.out.println("Dictionary: " + languageJson.get("dictionary"));
                System.out.println("Phrase: " + languageJson.get("phrase"));
                System.out.println("Translation: " + languageJson.get("translation")); // Fixed typo
                System.out.println("Lesson: " + languageJson.get("lesson"));
                System.out.println("Section: " + languageJson.get("section"));
                System.out.println("Course: " + languageJson.get("course"));
                System.out.println("Languages: " + languageJson.get("languages"));
                System.out.println("Pairs: " + languageJson.getOrDefault("pairs", "N/A"));
                System.out.println("Picture: " + languageJson.getOrDefault("picture", "N/A"));
                System.out.println("--------------------");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads gamified information from the Gamified.json file and displays it in the console.
     */
    private static void loadAndDisplayGamifiedInfo() {
        System.out.println("\nGamified Information:");
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("json/Gamified.json")) {
            JSONArray gamifiedArray = (JSONArray) parser.parse(reader);
            for (Object obj : gamifiedArray) {
                JSONObject gamifiedJson = (JSONObject) obj;
                System.out.println("Item Name: " + gamifiedJson.get("itemName"));
                System.out.println("Item Type: " + gamifiedJson.get("itemType"));
                System.out.println("Rarity: " + gamifiedJson.get("rarity"));
                System.out.println("Next Loot Crate At: " + gamifiedJson.get("nextLootCrateAt"));
                System.out.println("Unlocked Items: " + gamifiedJson.get("unlockedItems"));
                System.out.println("Opened Item: " + gamifiedJson.get("openedItem"));
                System.out.println("Available Items: " + gamifiedJson.get("availableItems"));
                System.out.println("--------------------");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}