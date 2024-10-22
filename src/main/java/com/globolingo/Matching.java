package com.globolingo;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Alexander Hughes
 * This class will handle the Matching question type, a user is presented with a picture and a series
 * of words to choose from.
 */
public class Matching implements Question  {
    private ArrayList<Word> words;
    private Picture picture;
    private String answer;

        // Constructor not in UML
    public Matching(ArrayList<Word> words, Picture picture)  {

    }

        // Getter not present in UML
    public ArrayList<Word> getWords() { return this.words; }

    public Picture getPicture() { return this.picture; }

    @Override
    public boolean isCorrect(String input) {
        return input.equalsIgnoreCase(this.answer);
    }

    @Override
    public void getUserInput() {
        //TODO TEMP IMPLEMENTATION UNTIL UI IMPLEMENTED
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter response");
        String input = keyboard.nextLine();
        if(isCorrect(input))  {
            //TODO tracking data with lesson
            System.out.println("That is correct!");
        } else {
            System.out.println("That is incorrect.");
        }
    }

    @Override
    public String getAnswer() { return this.answer; }

        // Setter not present in UML
    public void setWords(ArrayList<Word> words)  {
        this.words = words;
    }

    public void setPicture(Picture picture)  {
        this.picture = picture;
    }

    public void setAnswer(String answer)  {
        this.answer = answer;
    }
}
