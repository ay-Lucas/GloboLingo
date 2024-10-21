package com.globolingo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

    public static boolean saveUserList(ArrayList<User> userList) {
        JSONArray jsonUsers = new JSONArray();

        for (User user : userList) {
            jsonUsers.add(getUserJSON(user));
        }

        return writeToFile(jsonUsers, USER_FILE_NAME);
    }

    private static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put("username", user.getUsername());
        userDetails.put("firstName", user.getFirstName());
        userDetails.put("lastName", user.getLastName());
        userDetails.put("password", user.getPassword());
        userDetails.put("level", user.getLevel());
        userDetails.put("UUID", user.getUUID().toString());
        userDetails.put("loggedIn", user.isLoggedIn());

        addAvatarDetails(userDetails, user);
        addProgressDetails(userDetails, user);

        return userDetails;
    }

    private static void addAvatarDetails(JSONObject userDetails, User user) {
        Avatar avatar = user.getAvatar();
        if (avatar != null) {
            JSONObject avatarJSON = new JSONObject();
            avatarJSON.put("name", avatar.getName());
            JSONArray unlockedAvatars = new JSONArray();
            for (Avatar unlockedAvatar : user.getUnlockedAvatars()) {
                unlockedAvatars.add(unlockedAvatar.getName());
            }
            avatarJSON.put("unlocked", unlockedAvatars);
            userDetails.put("avatar", avatarJSON);
        }
    }

    private static void addProgressDetails(JSONObject userDetails, User user) {
        Progress progress = user.getProgress();
        if (progress != null) {
            JSONObject progressJSON = new JSONObject();
            progressJSON.put("completedSections", progress.getCompletedSections().size());
            progressJSON.put("completedLessons", progress.getCompletedLessons());
            progressJSON.put("nextLootCrateAt", progress.getNextLootCrateProgress());
            userDetails.put("progress", progressJSON);
        }
    }

    public static boolean saveLanguageList(ArrayList<Course> courseList) {
        JSONArray jsonLanguages = new JSONArray();
        JSONObject languagesWrapper = new JSONObject();

        for (Course course : courseList) {
            jsonLanguages.add(getCourseJSON(course));
        }

        languagesWrapper.put("Languages", jsonLanguages);
        JSONArray wrappedArray = new JSONArray();
        wrappedArray.add(languagesWrapper);

        return writeToFile(wrappedArray, LANGUAGE_FILE_NAME);
    }

    private static JSONObject getCourseJSON(Course course) {
        JSONObject courseDetails = new JSONObject();
        courseDetails.put("language", course.getLanguage());
        courseDetails.put("course", course.getTitle());

        JSONObject sectionDetails = new JSONObject();
        Section section = course.getSections().get(0); // Assuming we're dealing with the first section
        sectionDetails.put("title", section.getTitle());
        sectionDetails.put("subject", section.getSubject());
        sectionDetails.put("sectionProgress", 0); // You might want to calculate this
        sectionDetails.put("userScore", section.getUserScore());
        sectionDetails.put("maxscore", section.getMaxScore());
        sectionDetails.put("isCompleted", false); // You might want to determine this

        courseDetails.put("section", sectionDetails);

        JSONObject lessonDetails = new JSONObject();
        Lesson lesson = section.getLessons().get(0); // Assuming we're dealing with the first lesson
        lessonDetails.put("name", lesson.getName());
        lessonDetails.put("difficulty", lesson.getDifficulty());
        lessonDetails.put("isCompleted", false); // You might want to determine this

        JSONArray questionsArray = new JSONArray();
        for (Question question : lesson.getQuestions()) {
            questionsArray.add(getQuestionJSON(question));
        }
        lessonDetails.put("questions", questionsArray);

        courseDetails.put("lesson", lessonDetails);

        return courseDetails;
    }

    private static JSONObject getQuestionJSON(Question question) {
        JSONObject questionDetails = new JSONObject();
        questionDetails.put("type", question.getType());
        questionDetails.put("word", question.getWord());
        questionDetails.put("prompt", question.getPrompt());
        questionDetails.put("answer", question.getAnswer());
        questionDetails.put("isCorrect", question.isCorrect());

        // Add other question-specific details based on the question type
        if (question.getType().equals("Matching")) {
            questionDetails.put("picture", question.getPicture());
            JSONArray pairsArray = new JSONArray();
            JSONObject pairObject = new JSONObject();
            pairObject.put(question.getWord(), question.getAnswer());
            pairsArray.add(pairObject);
            questionDetails.put("pairs", pairsArray);
        } else if (question.getType().equals("Multiple Choice")) {
            questionDetails.put("options", question.getOptions());
            questionDetails.put("phrase", question.getPhrase());
        } else if (question.getType().equals("Flashcard")) {
            questionDetails.put("phrase", question.getPhrase());
            questionDetails.put("translation", question.getTranslation());
        }

        return questionDetails;
    }

    private static boolean writeToFile(JSONArray jsonArray, String fileName) {
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(jsonArray.toJSONString());
            file.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
