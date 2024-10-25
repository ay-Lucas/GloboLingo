package com.globolingo;

/**
 * @author Alexander Hughes
 * This class implements Flashcard question type, user is presented
 * a foreign prompt and has to input the answer in english, typed response.
 */
public class Flashcard implements Question  {
    private String prompt;
    private String answer;
    private boolean correct = false;
    
        //UML has C in flashcard capitalized, may need to be updated.
    public Flashcard(Word word)  {
        this.answer = word.getEnglishWord();
        this.prompt = word.getTranslation();
    }

    public Flashcard(Phrase phrase)  {
        this.answer = phrase.getEnglishPhrase();
        this.prompt = phrase.getTranslationString();
    }

        // Getter not present in UML
    /**
     * 
     * @return the Word prompt
     */
    public String getPrompt() { return this.prompt; }

    /**
     * @return the boolean value of if this question was answered correctly, default false
     */
    @Override
    public boolean isCorrect() {
        return this.correct;
    }

    /**
     * compares input to english prompt, sets correct boolean.
     * @param input ENGLISH word as input
     */
    @Override
    public void getUserInput(String input) {
        this.correct = input.equalsIgnoreCase(answer);
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
     * @param prompt String value of the prompt of this flashcard
     */
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
    
    /**
     * @param answer String value of the answer
     */
    public void setAnswer(String answer)  {
        this.answer = answer;
    }

    @Override
    public String toString()  {
        return "What does \"" + this.prompt + "\" mean in English?";
    }
}
