package com.globolingo;
import com.narriation.Narriator;

/**
 * @author Alexander Hughes
 * This class implements the Narrated question type, which presents the user with
 * a sound byte of the prompt in spanish and they have to type in the translation.
 */
public class NarratedQ implements Question  {
    private String answer;
    private String prompt;
    private boolean correct = false;

    /**
     * Constructor
     * @param prompt Spanish prompt to be played
     * @param answer English answer
     */
    public NarratedQ(Word word)  {
        this.prompt = word.getTranslation();
        this.answer = word.getEnglishWord();
    }
    
    public NarratedQ(Phrase phrase)  {
        this.prompt = phrase.getTranslationString();
        this.prompt = phrase.getEnglishPhrase();
    }

    /**
     * Plays the prompt as a sound
     */
    public void playSound()  {
        System.out.println("...playing sound...");
        Narriator.playSound(prompt);
    }

    /**
     * 
     * @return Boolean if question was answered correctly, default false
     */
    @Override
    public boolean isCorrect() {
        return this.correct;
    }

    /**
     * 
     * @param input String to be compared to the answer
     */
    @Override
    public void getUserInput(String input) {
        this.correct = input.equalsIgnoreCase(answer);
    }

    /**
     * 
     * @return String value of the answer
     */
    @Override
    public String getAnswer() {
        return this.answer;
    }

    @Override
    public String toString()  {
        return "What does this mean in english? Please type in your response.";
    }
}