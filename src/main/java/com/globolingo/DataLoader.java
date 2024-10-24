package com.globolingo;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * The DataLoader class is responsible for loading user information
 * from User.json
 */
public class DataLoader extends DataConstants {

    public static void main(String[] args) {
        getUsers();
    }

    /**
     * Gets an ArrayList of Users by reading and parsing User data from User.json
     * 
     * @return ArrayList of Users
     */
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_PATH);
            JSONArray usersJSON = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < usersJSON.size(); i++) {
                JSONObject userJSON = (JSONObject) usersJSON.get(i);
                String username = (String) userJSON.get(USER_USERNAME);
                String password = (String) userJSON.get(USER_PASSWORD);
                String firstName = (String) userJSON.get(USER_FIRSTNAME);
                String lastName = (String) userJSON.get(USER_LASTNAME);
                int level = Integer.parseInt(userJSON.get(USER_LEVEL).toString());
                UUID id = UUID.fromString((String) userJSON.get(USER_UUID));

                JSONObject avatarObj = (JSONObject) userJSON.get(USER_AVATAR);
                String avatarName = (String) avatarObj.get(USER_AVATAR_NAME);
                JSONArray unlockedAvatarsJSON = (JSONArray) avatarObj.get(USER_AVATAR_UNLOCKED);
                AvatarManager avatarManager = new AvatarManager();
                ArrayList<Avatar> unlockedAvatars = new ArrayList<>();
                for (int j = 0; j < unlockedAvatarsJSON.size(); j++) {
                    Avatar unlockedAvatar = avatarManager.getAvatar(unlockedAvatarsJSON.get(j).toString());
                    unlockedAvatars.add(unlockedAvatar);
                }
                Avatar avatar = avatarManager.getAvatar(avatarName);
                User user = new User(username, password, firstName, lastName, id, level, avatar, unlockedAvatars);
                JSONArray coursesJsonArray = (JSONArray) userJSON.get(USER_COURSES);
                for (int j = 0; j < coursesJsonArray.size(); j++) {
                    JSONObject courseObject = (JSONObject) coursesJsonArray.get(j);
                    String languageStr = (String) courseObject.get(USER_COURSES_LANGUAGE);
                    Language language = Language.valueOf(languageStr.toUpperCase());
                    user.addCourse((new Course(language, user)));
                    // TODO: Uncomment once Course can load Lessons, and add currentLesson to User
                    // int currentLesson =
                    // Integer.parseInt(courseObject.get(USER_COURSES_CURRENT_LESSON).toString());
                }
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

}
