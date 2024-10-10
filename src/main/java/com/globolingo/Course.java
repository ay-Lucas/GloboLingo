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
        // Implementation for creating a lesson
    }
    
    public Section viewSection() {
        return this.currentSection;
    }

    public void completeSection(Section section) {
        // Implementation for completing a section
    }

    public void aceSection(Section section) {
        // Implementation for acing a section
    }
    
    public Section nextSection() {
        int currentIndex = sections.indexOf(currentSection);
        if (currentIndex < sections.size() - 1) {
            return sections.get(currentIndex + 1);
        }
        return null;
    }

    public Item awardLootCrateForCompletion() {
        // Implementation for awarding loot crate for completion
        return null;
    }

    public Item awardLootCrateForAcing() {
        // Implementation for awarding loot crate for acing
        return null;
    }
    
    public int viewResults() {
        // Implementation for viewing results
        return 0;
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