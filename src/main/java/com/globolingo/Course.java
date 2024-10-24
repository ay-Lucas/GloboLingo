package com.globolingo;

import java.util.ArrayList;

public class Course {
    private ArrayList<Lesson> lessons;
    private Lesson currentLesson;
    private Language language;
    private User user;
    
    public Lesson getCurrentLesson() {
        return currentLesson;
    }
    
    public void setCurrentLesson(Lesson lesson) {
        this.currentLesson = lesson;
    } 

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
        ArrayList<Question> questions = new ArrayList<>();
        Lesson newLesson = new Lesson(subject, difficulty, questions, 0, 100);
        lessons.add(newLesson);
    }

    public int viewResults() {
        int totalScore = 0;
        for (Lesson lesson : lessons) {
            totalScore += lesson.getUserScore();
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

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setUser(User user) {
        this.user = user;
    }
}