package com.globolingo;
import java.util.ArrayList;

public class Course  {

    private String title;
    private String subject;
        // this is listed as List<Section> in UML
    private ArrayList<Section> sections;
    private Section currentSection;
    private Language language;

        // No constructor in UML
    public Course(String title, String subject, ArrayList<Section> sections, Language language)  {

    }

        // String difficultyLevel should probably be int difficulty as in section/question
        // Also, this method is redundant with generateLesson in Section.
    public void createLesson(String subject, String difficultyLevel)   {

    }
    
        // Formerly viewLesson(): LessonPlan, should be viewSection(): Section
    public Section viewSection()  { return this.currentSection; }

    public void completeSection(Section section)  {
        
    }

    public void aceSection(Section section)  {

    }
    
    public Section nextSection()  {

    }

    public Item awardLootCrateForCompletion()  {

    }

    public Item awardLootCrateForAcing()  {

    }
    
    public int viewResults()  {
        
    }

        // These getters not present in UML
    public String getTitle()  { return this.title; }

    public String getSubject()  { return this.subject; }

    public ArrayList<Section> getSections()  { return this.sections; }

    public Language getLanguage()  { return this.language; }

        // These setters notpresent in UML

    public void setTitle(String title)  {

    }

    public void setSubject(String subject)  {

    }

    public void setSections(ArrayList<Section> sections)  {

    }

    public void setCurrentSection(Section section)  {

    }

    public void setLanguage(Language language)  {
        
    }
}
