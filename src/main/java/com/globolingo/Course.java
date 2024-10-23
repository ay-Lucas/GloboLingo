package com.globolingo;

import java.util.ArrayList;

public class Course {
    private ArrayList<Lesson> lessons;
    private Lesson currentLesson;
    private Language language;
    private User user;

    public Course(Language language, User user) {
        this.language = language;
        this.lessons = new ArrayList<>();
        this.language = language;
        this.user = user;
    }

    public Course(Language language, User user, int currentLessonNum) {
        this.language = language;
        this.lessons = new ArrayList<>();
        this.currentLesson = lessons.get(currentLessonNum);
        this.language = language;
        this.user = user;
    }

    public void createLesson(String subject, int difficulty) {
        if (currentSection != null) {
            Lesson newLesson = currentSection.generateLesson();
            newLesson.setName(subject);
            newLesson.setDifficulty(difficulty);
            currentSection.getLessons().add(newLesson);
        }
    }

    public int viewResults() {
        int totalScore = 0;
        for (Section section : sections) {
            totalScore += section.getUserScore();
        }
        return totalScore;
    }

    // Getters

    public Language getLanguage() {
        return this.language;
    }

    public User getUser() {
        return this.user;
    }

    // Setters
    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }

    public void setCurrentSection(Section section) {
        this.currentSection = section;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
