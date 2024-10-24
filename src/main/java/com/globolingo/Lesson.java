package com.globolingo;
import java.awt.SystemTray;
import java.util.ArrayList;
import java.util.Random;


public class Lesson  {

    private String name;
    private boolean isComplete;
    private ArrayList<Question> questions;
    private int userScore;
    private int maxScore;
        
    public Lesson(String name)  {
        this.userScore = 0;
        this.maxScore = 10;
        this.isComplete = false;
        this.name = name;
        this.generateQuestions();
    }
        // Constructor not present in UML
    public Lesson(String name, ArrayList<Question> questions, int userScore, int maxScore)  {
        // Name should probably be subject
        this.setName(name);
        this.setQuestions(questions);
        this.setUserScore(userScore);
        this.setMaxScore(maxScore);

    }
    public String getName()  { return this.name; }

    public boolean getIsComplete()  { return this.isComplete; }

    public ArrayList<Question> getQuestions() { return this.questions; }

    public int getUserScore()  { return this.userScore; }

    public int getMaxScore()  { return this.maxScore; }

    public void generateQuestions()  {
        ArrayList<Question> tq = new ArrayList<>();
        for(int i = 0; i < 9; i++)  {
            Question temp;
            Word word;
            Phrase phrase;
            switch(i)  {
                case 0,1:
                    temp = new MultipleChoice(word);
                    break;
                case 2,3:
                    temp = new MultipleChoice(phrase);
                    break;
                case 4,5,6:
                    temp = new SentenceBuild(phrase);
                    break;
                case 7,8:
                    temp = new Flashcard(word);
                    break;
                case 9:
                    temp = new Flashcard(phrase);
                default:
                    System.out.println("Something went wrong in generating questions.");
            }
        }
        this.setQuestions(tq);
    }

        // No setters present in UML
    public void setName(String name)  {
        this.name = name;
    }

    public void setCompletion(boolean completion)  {
        this.isComplete = completion;
    }

    public void setQuestions(ArrayList<Question> questions)  {
        this.questions = questions;
    }

    public void setUserScore(int userScore)  {
        this.userScore = userScore;
    }

    public void setMaxScore(int maxScore)  {
        this.maxScore = maxScore;
    }
}
