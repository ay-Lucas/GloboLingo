package com.globolingo;

import java.util.ArrayList;

public class ProgressList {
    private ArrayList<Progress> progressList;
    private static ProgressList instance = null;

    private ProgressList() {
        progressList = new ArrayList<>();
    }

    public static ProgressList getInstance() {
        if (instance == null) {
            instance = new ProgressList();
        }
        return instance;
    }

    /**
     * Gets the Progress of each Course a User has started and returns it in an
     * ArrayList
     * 
     * @param username of User
     * @return ArrayList of Progress for each Course a User has started
     */
    public ArrayList<Progress> getUserProgress(String username) {
        ArrayList<Progress> userProgress = new ArrayList<>();
        for (Progress progress : progressList) {
            if (progress.getCourse().getUser().getUsername().equals(username)) {
                userProgress.add(progress);
            }
        }
        if (userProgress.size() < 0)
            return null;
        return userProgress;
    }

    /**
     * Gets the Progress of the respective User and Course
     * 
     * 
     * @param username    of User
     * @param courseTitle
     * @return
     */
    public Progress getCourseProgress(String username, String courseTitle) {
        for (Progress progress : progressList) {
            if (progress.getCourse().getUser().getUsername().equals(username)
                    && progress.getCourse().getTitle().equals(courseTitle)) {
                return progress;
            }
        }
        return null;
    }

    public void addProgress(Progress progress) {
        progressList.add(progress);
    }

    public ArrayList<Progress> getProgressList() {
        return progressList;
    }

    public void saveProgress() {

    }

    public void save() {

    }
}
