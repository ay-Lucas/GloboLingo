package com.globolingo;
import java.util.ArrayList;

/**
 * @author Alexander Hughes
 * This class comprises a collection of foreign words and an english phrase,
 * allows user to "construct" the phrase with the individual words.
 */
public class Phrase {
    private String phrase;
    private ArrayList<String> translation;

        // No constructor in  UML, adding here
    /**
     * Constructor
     * @param phrase The phrase in english
     * @param translation ArrayList of type String, will be the phrase in the foreign language
     */
    public Phrase(String phrase, ArrayList<String> translation)  {
        this.phrase = phrase;
        this.translation = translation;
    }
    /**
     * @return the String value of the phrase in english
     */
    public String getPhrase()  { return this.phrase; }

    /**
     * @return The ArrayList<String> of the translated phrase
     */
    public ArrayList<String> getTranslation()  { return this.translation; }

        // No setters in UML, adding here
    public String getTranslationString() {
        String ret = "";
        for(int i = 0; i<translation.size(); i++)  {
            ret += translation.get(i)+" ";
        }
        return ret;
    }
    /**
     * 
     * @param phrase String value of english phrase
     */
    public void setPhrase(String phrase)  {
        this.phrase = phrase;
    }
    
    /**
     * 
     * @param translation ArrayList<String> value of translated phrase
     */
    public void setTranslation(ArrayList<String> translation)  {
        this.translation = translation;
    }
}
