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

    public Progress getUser(String username) {
        for (Progress progress : progressList) {
            if (progress.getCourse().getUser().getUsername().equals(username)) {
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

    public void editUser() {

    }

    public void saveProgress() {

    }

    //public double getOverallProgress() {

    //}

    public void save() {

    }
}
