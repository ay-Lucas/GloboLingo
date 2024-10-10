package com.globolingo;
import java.util.ArrayList;

public class Progress {
    private Course course;
    private ArrayList<Section> completedSections;
    private int completedLessons;
    private int nextLootCrateAt;

    public Progress(Course course) {
        this.setCourse(course);
        this.completedSections = new ArrayList<>();
        this.completedLessons = 0;
        this.nextLootCrateAt = 5;
    }

    public Course getCourse() { 
        return this.course; 
    }

    public void setCourse(Course course) {
        if (course != null) {
            this.course = course;
        } else {
            throw new IllegalArgumentException("Course cannot be null");
        }
    }

    public ArrayList<Section> getCompletedSections() {
        return this.completedSections;
    }

    public int getCompletedLessons() {
        return this.completedLessons;
    }

    public int getNextLootCrateProgress() {
        return this.nextLootCrateAt;
    }

    public void completeLesson() {
        this.completedLessons++;
    }

    public void completeSection(Section section) {
        this.completedSections.add(section);
    }

    public void setNextLootCrateAt(int progress) {
        this.nextLootCrateAt = progress;
    }

    public String viewProgress() {
        return this.completedSections.size() + " out of " + course.getSections().size() +
            " sections completed, " + this.getCompletionPercentage() + "% of course completed.";
    }

    public LootCrate awardLootCrateForLevelUp() {
        LootCrate crate = new LootCrate();
        return crate;
    }
    
    public int getCompletionPercentage() {
        int total = course.getSections().size();
        int completed = this.completedSections.size();
        if (total == 0) {
            return 0;
        }
        return (completed * 100) / total;
    }

    public int getNextLootCraftProgress() { 
        return nextLootCrateAt; 
    }

    public void setCompletedSections(ArrayList<Section> sections) {
        if (sections != null) {
            this.completedSections = sections;
        }
    }

    public void setCompletedLessons(int completedLessons) {
        if (completedLessons >= 0) {
            this.completedLessons = completedLessons;
        }
    }
}