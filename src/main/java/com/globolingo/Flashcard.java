package com.globolingo;
import java.util.Scanner;

/**
 * @author Alexander Hughes
 * This class implements Flashcard question type, user is presented
 * a prompt and has to input the answer, typed response.
 */
public class Flashcard implements Question  {
    private Word prompt;
    private String answer;
    
        //UML has C in flashcard capitalized, may need to be updated.
    public Flashcard(Word prompt, String answer)  {
        setPrompt(prompt);
        setAnswer(answer);
    }

        // Getter not present in UML
    /**
     * 
     * @return the Word prompt
     */
    public Word getPrompt() { return this.prompt; }

    /**
     * compares input with the answer
     * @param input input to be compared
     * @return true or false, correct or incorrect
     */
    @Override
    public boolean isCorrect(String input) {
        return input.equalsIgnoreCase(this.answer);
    }

    /**
     * This is probably a temp implementation, gathers input via scanner,
     * uses isCorrect to determine if correct or not.
     */
    @Override
    public void getUserInput() {
        //TODO TEMP IMPLEMENTATION
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter response");
        String input = keyboard.nextLine();
        if(isCorrect(input)) {
            //TODO Track answer and such needs to be implmented with lesson
            System.out.println("That's correct!");
        } else {
            System.out.println("That is incorrect.");
        }
    }

    /**
     * 
     * @return The answer to this flashcard
     */
    @Override
    public String getAnswer() { return this.answer; }
    
        // Setter not present in UML
    /**
     * 
     * @param prompt Word of this flashcard
     */
    public void setPrompt(Word prompt) {
        this.prompt = prompt;
    }
    
    /**
     * @param answer String value of the answer
     */
    public void setAnswer(String answer)  {
        this.answer = answer;
    }
}
