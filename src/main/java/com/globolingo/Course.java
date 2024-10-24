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
<<<<<<< Updated upstream
        this.lessons = new ArrayList<>();
        this.currentLesson = lessons.get(currentLessonNum);
        this.language = language;
        this.user = user;
=======
        this.user = user;
        this.lessons = new ArrayList<>();
        if (!lessons.isEmpty() && currentLessonNum < lessons.size()) {
            this.currentLesson = lessons.get(currentLessonNum);
        }
    public void addSection(Section section) {
        this.sections.add(section);
        if (this.currentSection == null) {
            this.currentSection = section;
        }
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
    public ArrayList<Lesson> getLessons() {
        return this.lessons;
    }

    public Lesson getCurrentLesson() {
        return this.currentLesson;
    }
>>>>>>> Stashed changes

    public Language getLanguage() {
        return this.language;
    }

    public User getUser() {
        return this.user;
    }
<<<<<<< Updated upstream

    // Setters
    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }

    public void setCurrentSection(Section section) {
        this.currentSection = section;
=======
    public String getTitle() { return this.title; }
    public String getSubject() { return this.subject; }
    public ArrayList<Section> getSections() { return this.sections; }
    public Language getLanguage() { return this.language; }
    public User getUser() { return this.user; }

    // Setters
    public void setCurrentLesson(Lesson lesson) {
        this.currentLesson = lesson;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
>>>>>>> Stashed changes
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setUser(User user) {
        this.user = user;
    }
<<<<<<< Updated upstream
}
=======
    public void setTitle(String title) { this.title = title; }
    public void setSubject(String subject) { this.subject = subject; }
    public void setSections(ArrayList<Section> sections) { this.sections = sections; }
    public void setCurrentSection(Section section) { this.currentSection = section; }
    public void setLanguage(Language language) { this.language = language; }
    public void setUser(User user) { this.user = user; }
}
>>>>>>> Stashed changes
