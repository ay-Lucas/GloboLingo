package com.globolingo;
import java.util.ArrayList;

public class Phrase {
    private String phraseEnglish;
    private ArrayList<Word> translation;

        // No constructor in  UML, adding here
    public Phrase(String phraseEnglish, ArrayList<Word> translation)  {

    }
    public String getPhraseEnglish()  { return this.phraseEnglish; }

    public ArrayList<Word> getTranslation()  { return this.translation; }

        // No setters in UML, adding here
    public void setPhraseEnglish(String phrase)  {

    }
    
    public void setTranslation(ArrayList<Word> translation)  {

    }
}
