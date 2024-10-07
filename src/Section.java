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

        // No constructor in UML
    public Section(String title, String subject, int difficulty, ArrayList<Lesson> lessons, int userScore, int maxScore)  {

    }

    public String getTitle()  { return this.title; }

    public String getSubject()  { return this.subject; }

    public int getDifficulty()  { return this.difficulty; }

    public int getUserScore()  { return this.userScore; }

    public int getMaxScore()  { return this.maxScore; }

    public boolean getCompletionStatus()  { return this.isComplete; }

        // These getters not present in UML
    public ArrayList<Lesson> getLessons()  { return this.lessons; }

    public int getSectionProgress()  { return this.sectionProgress; }

    public Lesson generateLesson()  { 

    }
        // No setters present 
    public void setTitle(String title)  {

    }
    
    public void setSubject(String subject)  {

    }

    public void setDifficulty(int difficulty)  {

    }

    public void setUserScore(int userScore)  {

    }

    public void setMaxScore(int maxScore)  {

    }
    
    public void setCompletionStatus(boolean isComplete)  {

    }
    
    public void setLessons(ArrayList<Lesson> lessons)  {

    }
    public void setSectionProgress(int sectionProgress)  {

    }
}