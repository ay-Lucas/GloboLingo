public class Word  {
    
    private Language language;
    private String englishWord;
    private String translation;
    private String definition;

        // No constructor in UML
    public Word(Language language, String englishWord, String translation, String definition) {

    }

    public String getWord()  { return this.englishWord; }

    public String getTranslation() { return this.translation; }
    
    public String getDefinition()  { return this.definition; }

        // No setters in UML, adding here
    public void setLanguage(Language language)  {

    }

    public void setEnglishWord(String word)  {

    }

    public void setTranslation(String translation)  {

    }

    public void setDefinition(String definition)  {

    }
}