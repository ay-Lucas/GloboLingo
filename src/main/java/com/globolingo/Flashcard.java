package com.globolingo;
public class Flashcard implements Question  {
    private Word prompt;
    
        //UML has C in flashcard capitalized, may need to be updated.
    public Flashcard(String prompt, String answer)  {

    }

        // Getter not present in UML
    public Word getPrompt() { return this.prompt; }

    @Override
    public boolean isCorrect() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void getUserInput() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getAnswer() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
        // Setter not present in UML
    public void setPrompt() {
        
    }
}
