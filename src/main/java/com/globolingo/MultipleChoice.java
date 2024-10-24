package com.globolingo;
import java.util.ArrayList;

/**
 * @author Alexander Hughes
 * This is the class for Multiple Choice question type, user is presented 4 options and selects
 * one of the options.
 */
public class MultipleChoice implements Question  {
        // Likely will need ot be updated to arraylist in class and UML
    private ArrayList<String> options;
    private Word word;
    private Phrase phrase;
    private String answer;
    private boolean correct = false;

    /**
     * Constructor
     * @param options ArrayList<String> of the options, should be a list of 4 options, convert Phrases to String before passing
     * @param answer String answer of the correct answer.
     */
    public MultipleChoice(ArrayList<String> options, Word word)  {
        this.options = options;
        this.word = word;
        this.phrase = null;
        this.answer = word.getTranslation();
        
    }
    public MultipleChoice(ArrayList<String> options, Phrase phrase)  {
        this.options = options;
        this.phrase = phrase;
        this.word = null;
        this.answer = phrase.getPhrase();
        
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
     * @return the boolean value of if the question was answered correctly or not, default false.
     */
    @Override
    public boolean isCorrect() {
        return this.correct;
    }

    /**
     * Grabs the input and compares to the answer, if equal, then sets correct to true.
     * @param input the String value input to be compared to the answer NOTE: can be A B C D
     */
    @Override
    public void getUserInput(String input) {
        String temp;
        switch(input.toLowerCase())  {
            case "a": temp = options.get(0); break;
            case "b": temp = options.get(1); break;
            case "c": temp = options.get(2); break;
            case "d": temp = options.get(3); break;
            default: temp = input;
        }
        this.correct = temp.equalsIgnoreCase(answer);
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

    @Override
    public String toString()  {
        return "How do you say " + word.getEnglishWord() + " in " +
        word.getLanguage() + "?\n A) " + options.get(0) + "\nB) " +
        options.get(1) + "\nC) " + options.get(2) + "\nD) " + 
        options.get(3);
    }
}
