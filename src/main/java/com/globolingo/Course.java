package com.globolingo;

import java.util.ArrayList;

public class Course {
    private ArrayList<Lesson> lessons;
    private Lesson currentLesson;
    private Language language;
    private User user;
    private int completedLessons;
    private int MAX_LESSONS = 10;
    
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
        this.completedLessons = 0;
    }

    public Course(Language language, User user, int currentLessonNum) {
        this.language = language;
        this.lessons = new ArrayList<>();
        generateLessons();
        this.currentLesson = lessons.get(currentLessonNum);
        this.language = language;
        this.user = user;
    }


    public void generateLessons() {
        for(int i=1; i <= MAX_LESSONS; i++) {
            this.lessons.add(new Lesson(i));
            System.out.println("Loaded Lesson" + i);
        }
    }

    public void doLesson() {
        this.currentLesson.doQuestions();
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

    public int getCompletedLessons() {
        return completedLessons;
    }
    
    public void incrementCompletedLessons() {
        this.completedLessons++;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }
}
