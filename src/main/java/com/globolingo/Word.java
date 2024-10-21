package com.globolingo;

/**
 * @author Alexander Hughes
 * This class holds all values for a word, including its english and foreign counterparts
 */
public class Word implements Item {
    private Language language;
    private String englishWord;
    private String translation;
    private String definition;
    private String type;
    private String prompt;
    
    /**
     * Constructor
     * @param language the Language this word uses
     * @param englishWord English word
     * @param translation Translated word
     * @param definition A short definition of the word in question
     * @param type Subject of the word
     * @param prompt 
     */
    public Word(Language language, String englishWord, String translation, String definition, String type, String prompt) {
        this.language = language;
        this.englishWord = englishWord;
        this.translation = translation;
        this.definition = definition;
        this.type = type;
        this.prompt = prompt;
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
     * @return the String value of the definition of the word
     */
    public String getDefinition() {
        return definition;
    }

    /**
     * 
     * @return the subject of the word
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @return the String value prompt for the word
     */
    public String getPrompt() {
        return prompt;
    }

    /**
     * @return "Word"
     */
    public String getItemType() {
        return "Word";
    }

    /**
     * @return String value of word in English
     */
    public String getItemName() {
        return englishWord;
    }

    /**
     * @return "Common"
     */
    public String getRarity() {
        return "Common";
    }
}
