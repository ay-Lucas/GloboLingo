package com.globolingo;
public class SentenceBuild implements Question {
    
    private Phrase sentence;

        // No constructor in UML
    public SentenceBuild(Phrase sentence)  {

    }

        // Getter not in UML
    public Phrase getSentence() { return this.sentence; }

    @Override
    public String getAnswer()  {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isCorrect() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void getUserInput() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

        // No setters in UML
    public void setSentence(Phrase phrase)  {

    }
}
