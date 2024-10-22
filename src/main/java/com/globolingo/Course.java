package com.globolingo;
import java.util.ArrayList;

public class Course {
    private String title;
    private String subject;
    private ArrayList<Section> sections;
    private Section currentSection;
    private Language language;
    private User user;

    public Course(String title, String subject, Language language, User user) {
        this.title = title;
        this.subject = subject;
        this.sections = new ArrayList<>();
        this.language = language;
        this.user = user;
        this.currentSection = null;
    }

    public void addSection(Section section) {
        this.sections.add(section);
        if (this.currentSection == null) {
            this.currentSection = section;
        }
    }

    public void createLesson(String subject, int difficulty) {
        if (currentSection != null) {
            Lesson newLesson = currentSection.generateLesson();
            newLesson.setName(subject);
            newLesson.setDifficulty(difficulty);
            currentSection.getLessons().add(newLesson);
        }
    }
    
    public Section viewSection() {
        return this.currentSection;
    }

    public void completeSection(Section section) {
        section.setCompletionStatus(true);
        int totalScore = 0;
        int maxScore = 0;
        for (Lesson lesson : section.getLessons()) {
            totalScore += lesson.getUserScore();
            maxScore += lesson.getMaxScore();
        }
        section.setUserScore(totalScore);
        section.setMaxScore(maxScore);
        section.setSectionProgress(100);
    }

    public void aceSection(Section section) {
        section.setCompletionStatus(true);
        int maxScore = 0;
        for (Lesson lesson : section.getLessons()) {
            lesson.setUserScore(lesson.getMaxScore());
            maxScore += lesson.getMaxScore();
        }
        section.setUserScore(maxScore);
        section.setMaxScore(maxScore);
        section.setSectionProgress(100);
    }
    
    public Section nextSection() {
        int currentIndex = sections.indexOf(currentSection);
        if (currentIndex < sections.size() - 1) {
            return sections.get(currentIndex + 1);
        }
        return null;
    }
    
    public int viewResults() {
        int totalScore = 0;
        for (Section section : sections) {
            totalScore += section.getUserScore();
        }
        return totalScore;
    }

    // Getters
    public String getTitle() { return this.title; }
    public String getSubject() { return this.subject; }
    public ArrayList<Section> getSections() { return this.sections; }
    public Language getLanguage() { return this.language; }
    public User getUser() { return this.user; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setSubject(String subject) { this.subject = subject; }
    public void setSections(ArrayList<Section> sections) { this.sections = sections; }
    public void setCurrentSection(Section section) { this.currentSection = section; }
    public void setLanguage(Language language) { this.language = language; }
    public void setUser(User user) { this.user = user; }
}
