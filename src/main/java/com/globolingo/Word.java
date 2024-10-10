package com.globolingo;
public class Word implements Item {
    private Language language;
    private String englishWord;
    private String translation;
    private String definition;
    private String type;
    private String prompt;

    public Word(Language language, String englishWord, String translation, String definition, String type, String prompt) {
        this.language = language;
        this.englishWord = englishWord;
        this.translation = translation;
        this.definition = definition;
        this.type = type;
        this.prompt = prompt;
    }

    public Language getLanguage() {
        return language;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public String getTranslation() {
        return translation;
    }

    public String getDefinition() {
        return definition;
    }

    public String getType() {
        return type;
    }

    public String getPrompt() {
        return prompt;
    }

    public String getItemType() {
        return "Word";
    }

    public String getItemName() {
        return englishWord;
    }

    public String getRarity() {
        return "Common";
    }
}
