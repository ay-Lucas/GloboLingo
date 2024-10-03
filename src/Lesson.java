package globolingo;

import java.util.ArrayList;

public class Lesson  {

    private String name;
    private int difficulty;
    private boolean isComplete;
    private ArrayList<Question> questions;
    private int userScore;
    private int maxScore;
        
        // Constructor not present in UML
    public Lesson(String name, int difficulty, ArrayList<Question> questions, int userScore, int maxScore)  {
        
    }
    public String getName()  { return this.name; }

    public int getDifficulty()  { return this.difficulty; }

    public boolean getIsComplete()  { return this.isComplete; }

        // This getter not present in UML
    public ArrayList<Question> getQuestions() { return this.questions; }

    public int getUserScore()  { return this.userScore; }

    public int getMaxScore()  { return this.maxScore; }

    public void generateQuestions()  {

    }

        // No setters present in UML
    public void setName(String name)  {

    }

    public void setDifficulty(int difficulty)  {

    }

    public void setCompletion(boolean completion)  {

    }

    public void setQuestions(ArrayList<Question> questions)  {

    }

    public void setUserScore(int userScore)  {

    }

    public void setMaxScore(int maxScore)  {
        
    }
}