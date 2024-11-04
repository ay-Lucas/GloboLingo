package com.globolingo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

// Mock classes for Word and Phrase, if these are unavailable
class Word {
    private String englishWord;
    private String translation;
    private String language;

    public Word(String englishWord, String translation, String language) {
        this.englishWord = englishWord;
        this.translation = translation;
        this.language = language;
    }

    public String getEnglishWord() { return englishWord; }
    public String getTranslation() { return translation; }
    public String getLanguage() { return language; }
}

class Phrase {
    private String englishPhrase;
    private String translationString;
    private String language;

    public Phrase(String englishPhrase, String translationString, String language) {
        this.englishPhrase = englishPhrase;
        this.translationString = translationString;
        this.language = language;
    }

    public String getEnglishPhrase() { return englishPhrase; }
    public String getTranslationString() { return translationString; }
    public String getLanguage() { return language; }
}

public class MultipleChoiceTest {
    private MultipleChoice multipleChoiceFromWord;
    private MultipleChoice multipleChoiceFromPhrase;
    private ArrayList<String> options;

    @Before
    public void setUp() {
        options = new ArrayList<>(Arrays.asList("casa", "carro", "árbol", "gato"));
        
        Word word = new Word("house", "casa", "Spanish");
        Phrase phrase = new Phrase("How are you?", "¿Cómo estás?", "Spanish");

        multipleChoiceFromWord = new MultipleChoice(options, word);
        multipleChoiceFromPhrase = new MultipleChoice(options, phrase);
    }

    @Test
    public void testMultipleChoiceInitializationWithWord() {
        assertEquals("casa", multipleChoiceFromWord.getAnswer());
    }

    @Test
    public void testMultipleChoiceInitializationWithPhrase() {
        assertEquals("¿Cómo estás?", multipleChoiceFromPhrase.getAnswer());
    }

    @Test
    public void testIsCorrectInitiallyFalse() {
        assertFalse(multipleChoiceFromWord.isCorrect());
    }

    @Test
    public void testGetUserInputCorrectAnswerByOptionLetter() {
        multipleChoiceFromWord.getUserInput("a");
        assertTrue(multipleChoiceFromWord.isCorrect());
    }

    @Test
    public void testGetUserInputIncorrectAnswerByOptionLetter() {
        multipleChoiceFromWord.getUserInput("b");
        assertFalse(multipleChoiceFromWord.isCorrect());
    }

    @Test
    public void testGetUserInputCorrectAnswerByText() {
        multipleChoiceFromWord.getUserInput("casa");
        assertTrue(multipleChoiceFromWord.isCorrect());
    }

    @Test
    public void testGetUserInputIncorrectAnswerByText() {
        multipleChoiceFromWord.getUserInput("árbol");
        assertFalse(multipleChoiceFromWord.isCorrect());
    }

    @Test
    public void testGetUserInputCaseInsensitive() {
        multipleChoiceFromWord.getUserInput("CaSa");
        assertTrue(multipleChoiceFromWord.isCorrect());
    }

    @Test
    public void testToStringWithWord() {
        String expected = "How do you say house in Spanish?\n A) casa\nB) carro\nC) árbol\nD) gato";
        assertEquals(expected, multipleChoiceFromWord.toString());
    }

    @Test
    public void testToStringWithPhrase() {
        String expected = "How do you say How are you? in Spanish?\n A) casa\nB) carro\nC) árbol\nD) gato";
        assertEquals(expected, multipleChoiceFromPhrase.toString());
    }
}
