package com.globolingo;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author Alexander Hughes
 * This is the class for Multiple Choice question type, user is presented 4 options and selects
 * one of the options.
 */
public class MultipleChoice implements Question  {
        // Likely will need ot be updated to arraylist in class and UML
    private ArrayList<String> options;
    private String answer;

    /**
     * Constructor
     * @param options ArrayList<String> of the options, should be a list of 4 options, convert Phrases to String before passing
     * @param answer String answer of the correct answer.
     */
    public MultipleChoice(ArrayList<String> options, String answer)  {
        setOptions(options);
        setAnswer(answer);
    }

        // Getters not present in UML
    /**
    * 
    * @return the ArrayList<String> of options
    */
    public ArrayList<String> getOptions()  { return this.options; }

        // interface is String, class is int. Maybe make returntype generic for interface?
    
    /**
     * 
     * @return The String value of the answer
     */
    @Override
    public String getAnswer() { return this.answer; }

    /**
     * 
     * @return boolean if input is equal to the answer to this question.
     */
    @Override
    public boolean isCorrect(String input) {
        return this.answer.equalsIgnoreCase(input);
    }

    /**
     * Possibly a temp implementation, recieves input from Scanner, passes input to IsCorrect and outputs to console.
     * Will need to further implement tracking correct answers and such.
     */
    @Override
    public void getUserInput() {
        // Temp implementation before UI implementation
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter your answer.");
        String input = keyboard.nextLine();
        if(isCorrect(input))  {
            //TODO Implement all the tracking and stuff with Lesson
            System.out.println("Answer is correct.");
        } else { 
            System.out.println("Answer is incorrect.");
        }
        
    }
    /**
     * Sets options to input, called by constructor
     * @param options The ArrayList<String> of options
     */
        // Setters not present in UML
    public void setOptions(ArrayList<String> options)  {
        this.options = options;
    }
    
    /**
    * Sets answer to input, called by constructor
    * @param answer The String value of the answer
    */
    public void setAnswer(String answer)  {
        this.answer = answer;
    }
}
