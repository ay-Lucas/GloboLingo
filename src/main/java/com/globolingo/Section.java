package com.globolingo;
import java.util.ArrayList;

public class Section  {

    private String title;
    private String subject;
    private int difficulty;
    private ArrayList<Lesson> lessons;
    private boolean isComplete;
    private int sectionProgress;
    private int userScore;
    private int maxScore;

    public Section(String title, String subject, int difficulty, ArrayList<Lesson> lessons, int userScore, int maxScore)  {
        this.title = title;
        this.subject = subject;
        this.difficulty = difficulty;
        this.lessons = lessons != null ? lessons : new ArrayList<>();
        this.userScore = userScore;
        this.maxScore = maxScore;
        this.isComplete = false;
        this.sectionProgress = 0;
    }

    public String getTitle()  { return this.title; }

    public String getSubject()  { return this.subject; }

    public int getDifficulty()  { return this.difficulty; }

    public int getUserScore()  { return this.userScore; }

    public int getMaxScore()  { return this.maxScore; }

    public boolean getCompletionStatus()  { return this.isComplete; }

    public ArrayList<Lesson> getLessons()  { return this.lessons; }

    public int getSectionProgress()  { return this.sectionProgress; }

    public Lesson generateLesson()  { 
        Lesson lesson = new Lesson("New Lesson", this.difficulty, new ArrayList<>(), 0, 0);
        this.lessons.add(lesson);
        return lesson;
    }

    public void setTitle(String title)  {
        this.title = title;
    }
    
    public void setSubject(String subject)  {
        this.subject = subject;
    }

    public void setDifficulty(int difficulty)  {
        this.difficulty = difficulty;
    }

    public void setUserScore(int userScore)  {
        this.userScore = userScore;
    }

    public void setMaxScore(int maxScore)  {
        this.maxScore = maxScore;
    }
    
    public void setCompletionStatus(boolean isComplete)  {
        this.isComplete = isComplete;
    }
    
    public void setLessons(ArrayList<Lesson> lessons)  {
        this.lessons = lessons;
    }

    public void setSectionProgress(int sectionProgress)  {
        this.sectionProgress = sectionProgress;
    }

    // New methods added based on UML
    public void addLesson(Lesson lesson) {
        this.lessons.add(lesson);
    }

    public void removeLesson(Lesson lesson) {
        this.lessons.remove(lesson);
    }

    public void calculateProgress() {
        int completedLessons = 0;
        for (Lesson lesson : lessons) {
            if (lesson.getCompletionStatus()) {
                completedLessons++;
            }
        }
        this.sectionProgress = (completedLessons * 100) / lessons.size();
        this.isComplete = (this.sectionProgress == 100);
    }
}
