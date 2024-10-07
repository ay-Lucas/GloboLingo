import java.util.ArrayList;

public class Progress {
    private Course course;
    private ArrayList<Section> completedSections;
    private int completedLessons;
    private int nextLootCrateAt;

        // Constructor not in UML
    public Progress(Course course)  {

    }

    public String viewProgress()  {

    }

    public Item awardLootCrateForLevelUp()  {

    }

    public float getCompletionPercentage()  {

    }

    public int getNextLootCraftProgress()  { return nextLootCrateAt; }

    public void completeSection(Section section)  {
        
    }

    // Getters not present in UML
    public Course getCourse()  { return this.course; }
    
    public ArrayList<Section> getCompletedSections()  { return this.completedSections; }

    public int getCompletedLessons()  { return this.completedLessons; }

    // These setters not present in UML

    public void setCourse(Course course)  {

    }

    public void setCompletedSections(ArrayList<Section> sections)  {

    }

    public void setCompletedLessons(int completedLessons)  {

    }
}