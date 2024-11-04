package com.globolingo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

// Mock class for Word and Phrase in case they are not available
class Word {
    private String englishWord;
    private String translation;

    public Word(String englishWord, String translation) {
        this.englishWord = englishWord;
        this.translation = translation;
    }

    public String getEnglishWord() { return englishWord; }
    public String getTranslation() { return translation; }
}

class Phrase {
    private String englishPhrase;
    private String translationString;

    public Phrase(String englishPhrase, String translationString) {
        this.englishPhrase = englishPhrase;
        this.translationString = translationString;
    }

    public String getEnglishPhrase() { return englishPhrase; }
    public String getTranslationString() { return translationString; }
}

public class FlashcardTest {
    private Flashcard flashcardFromWord;
    private Flashcard flashcardFromPhrase;

    @Before
    public void setUp() {
        Word word = new Word("house", "casa");
        Phrase phrase = new Phrase("How are you?", "¿Cómo estás?");
        
        flashcardFromWord = new Flashcard(word);
        flashcardFromPhrase = new Flashcard(phrase);
    }

    @Test
    public void testFlashcardInitializationWithWord() {
        assertEquals("casa", flashcardFromWord.getPrompt());
        assertEquals("house", flashcardFromWord.getAnswer());
    }

    @Test
    public void testFlashcardInitializationWithPhrase() {
        assertEquals("¿Cómo estás?", flashcardFromPhrase.getPrompt());
        assertEquals("How are you?", flashcardFromPhrase.getAnswer());
    }

    @Test
    public void testIsCorrectInitiallyFalse() {
        assertFalse(flashcardFromWord.isCorrect());
    }

    @Test
    public void testGetUserInputCorrectAnswer() {
        flashcardFromWord.getUserInput("house");
        assertTrue(flashcardFromWord.isCorrect());
    }

    @Test
    public void testGetUserInputIncorrectAnswer() {
        flashcardFromWord.getUserInput("wrong answer");
        assertFalse(flashcardFromWord.isCorrect());
    }

    @Test
    public void testGetUserInputCaseInsensitive() {
        flashcardFromWord.getUserInput("HoUsE");
        assertTrue(flashcardFromWord.isCorrect());
    }

    @Test
    public void testToString() {
        assertEquals("What does \"casa\" mean in English?", flashcardFromWord.toString());
        assertEquals("What does \"¿Cómo estás?\" mean in English?", flashcardFromPhrase.toString());
    }
}
