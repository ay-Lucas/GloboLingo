package com.globolingo;

/**
 * @author Alexander Hughes
 *         This class holds all values for a word, including its english and
 *         foreign counterparts
 */
public class Word {
    private Language language;
    private String englishWord;
    private String translation;
    private String subject;

    /**
     * Constructor
     * 
     * @param language    the Language this word uses
     * @param englishWord English word
     * @param translation Translated word
     * @param subject     Subject of the word
     */
    public Word(Language language, String englishWord, String translation, String subject) {
        this.language = language;
        this.englishWord = englishWord;
        this.translation = translation;
        this.subject = subject;
    }

    /**
     * 
     * @return the Language of the word
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * 
     * @return the String value of the word in english
     */
    public String getEnglishWord() {
        return englishWord;
    }

    /**
     * 
     * @return the String value of the word in the foreign language
     */
    public String getTranslation() {
        return translation;
    }

    /**
     * 
     * @return the subject of the word
     */
    public String getSubject() {
        return subject;
    }

    public String toString() {
        return "\nEnglish world: " + englishWord +
                "\nTranslation word: " + translation +
                "\nSubject: " + subject +
                "\nLanguage: " + language + "\n";

    }
}
