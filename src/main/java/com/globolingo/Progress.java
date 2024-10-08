package com.globolingo;
import java.util.ArrayList;

public class Progress {
    private Course course;
    private ArrayList<Section> completedSections;
    private int completedLessons;
    private int nextLootCrateAt;

        // Constructor not in UML
    public Progress(Course course)  {
        this.setCourse(course);
    }

    public String viewProgress()  {
        //TODO this needs to be either removed or made better functional?
        // temp implementation
        return this.completedSections.size()+1 +" out of "+course.getSections().size()+
            " sections completed, "+this.getCompletionPercentage()+"% of course completed. ";
    }

    public LootCrate awardLootCrateForLevelUp()  {
        //TODO figure this out at some point
        // temp implementation
        LootCrate crate = new LootCrate();
        return crate;
    }

    public int getCompletionPercentage()  {
        int total = course.getSections().size();
        int completed = this.completedSections.size();
        int perc = ( total / completed * 100);
        return perc;
    }

    public int getNextLootCraftProgress()  { return nextLootCrateAt; }

    public void completeSection(Section section)  {
        completedSections.add(section);
    }

    // Getters not present in UML
    public Course getCourse()  { return this.course; }
    
    public ArrayList<Section> getCompletedSections()  { return this.completedSections; }

    public int getCompletedLessons()  { return this.completedLessons; }

    // These setters not present in UML

    public void setCourse(Course course)  {
        this.course = course;
    }

    public void setCompletedSections(ArrayList<Section> sections)  {

    }

    public void setCompletedLessons(int completedLessons)  {

    }
}
