package com.globolingo;
import java.util.ArrayList;

/**
 * @author Alexander Hughes
 * This class comprises a collection of foreign words and an english phrase,
 * allows user to "construct" the phrase with the individual words.
 */
public class Phrase {
    private String phraseEnglish;
    private ArrayList<Word> translation;

        // No constructor in  UML, adding here
    /**
     * Constructor
     * @param phraseEnglish The phrase in english
     * @param translation ArrayList of type Word, will be the phrase in the foreign language
     */
    public Phrase(String phraseEnglish, ArrayList<Word> translation)  {
        setPhraseEnglish(phraseEnglish);
        setTranslation(translation);
    }
    /**
     * @return the String value of the phrase in english
     */
    public String getPhraseEnglish()  { return this.phraseEnglish; }

    /**
     * @return The ArrayList<Word> of the translated phrase
     */
    public ArrayList<Word> getTranslation()  { return this.translation; }

        // No setters in UML, adding here
    /**
     * 
     * @param phrase String value of english phrase
     */
    public void setPhraseEnglish(String phrase)  {
        this.phraseEnglish = phrase;
    }
    
    /**
     * 
     * @param translation ArrayList<Word> value of translated phrase
     */
    public void setTranslation(ArrayList<Word> translation)  {
        this.translation = translation;
    }
}
