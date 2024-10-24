package com.globolingo;


/**
 * @author Alexander Hughes
 * This is the class for the Sentence Building question type
 */
public class SentenceBuild implements Question {
    
    private Phrase sentence;
    private boolean correct = false;

    /**
     * Constructor
     * @param sentence the Phrase of the sentence to be built
     */
        // No constructor in UML
    public SentenceBuild(Phrase sentence)  {
        this.sentence = sentence;
    }

        // Getter not in UML
    /**
     * @return The sentence to be built
     */
    public Phrase getSentence() { return this.sentence; }
     
    @Override
    public String getAnswer()  {
        // Based on how this would function, we know that the sentence is the answer, so just going to cap this;
        return this.sentence.getTranslation().toString();
    }

    /**
     * @param input String value of the input
     * @return boolean, true if equal to string value of sentence.
     */
    @Override
    public boolean isCorrect() {
        return this.correct;
    }

    
    @Override
    public void getUserInput(String input) {
        this.correct = input.equalsIgnoreCase(sentence.getTranslationString());
    }

    /**
     * Sets the input phrase to the sentence
     * @param phrase The phrase to be built
     */
        // No setters in UML
    public void setSentence(Phrase phrase)  {
        this.sentence = phrase;
    }
}
