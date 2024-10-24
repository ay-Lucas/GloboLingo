package com.globolingo;

import java.util.ArrayList;

/**
 * @author Alexander Hughes
 *         This class comprises a collection of foreign words and an english
 *         phrase,
 *         allows user to "construct" the phrase with the individual words.
 */
public class Phrase {
    private String englishPhrase;
    private Language language;
    private ArrayList<String> translationList;
    private String subject;

    // No constructor in UML, adding here
    /**
     * Constructor
     * 
     * @param phrase      The phrase in english
     * @param translation ArrayList of type String, will be the phrase in the
     *                    foreign language
     */
    public Phrase(Language language, String englishPhrase, ArrayList<String> translationList, String subject) {
        this.language = language;
        this.englishPhrase = englishPhrase;
        this.translationList = translationList;
        this.subject = subject;
    }

    /**
     * Gets the Phrase
     * 
     * @return the String value of the phrase in english
     */
    public String getEnglishPhrase() {
        return this.englishPhrase;
    }

    /**
     * Gets each string of the translated phrase as an ArrayList
     * 
     * @return The ArrayList<String> of the translated phrase
     */
    public ArrayList<String> getTranslationList() {
        return this.translationList;
    }

    /**
     * @return the translatedList as a String
     */
    public String getTranslationString() {
        String ret = "";
        for (int i = 0; i < translationList.size(); i++) {
            ret += translationList.get(i) + " ";
        }
        return ret;
    }

    /**
     * Sets the english phrase
     * 
     * @param phrase String value of english phrase
     */
    public void setEnglishPhrase(String englishPhrase) {
        this.englishPhrase = englishPhrase;
    }

    /**
     * Gets the language of Phrase
     * 
     * @return the Language of the word
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * Sets the language of Phrase
     *
     * @param language
     */
    public void setLanguage(Language language) {
        this.language = language;
    }

    /**
     * Gets the subject of Phrase
     * 
     * @return the subject of the phrase
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the subject of Phrase
     * 
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Sets the translation of Phrase
     * 
     * @param translationList ArrayList<String> value of translated phrase
     */
    public void setTranslation(ArrayList<String> translationList) {
        this.translationList = translationList;
    }

    public String toString() {
        return "English phrase: " + englishPhrase +
                "\nTranslated phrase: " + getTranslationString() +
                "\nSubject: " + subject +
                "\nLanguage: " + language + "\n";

    }
}
