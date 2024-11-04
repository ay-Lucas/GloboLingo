package com.globolingo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// Mock classes for Word and Phrase, if these are unavailable
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

// Mock class for Narriator to prevent actual sound playback during testing
class Narriator {
    public static void playSound(String prompt) {
        System.out.println("Playing sound for: " + prompt);
    }
}

public class NarratedQTest {
    private NarratedQ narratedQFromWord;
    private NarratedQ narratedQFromPhrase;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        Word word = new Word("house", "casa");
        Phrase phrase = new Phrase("How are you?", "¿Cómo estás?");

        narratedQFromWord = new NarratedQ(word);
        narratedQFromPhrase = new NarratedQ(phrase);
        
        // Capture System.out output to verify playSound output
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testNarratedQInitializationWithWord() {
        assertEquals("house", narratedQFromWord.getAnswer());
    }

    @Test
    public void testNarratedQInitializationWithPhrase() {
        assertEquals("How are you?", narratedQFromPhrase.getAnswer());
    }

    @Test
    public void testIsCorrectInitiallyFalse() {
        assertFalse(narratedQFromWord.isCorrect());
    }

    @Test
    public void testGetUserInputCorrectAnswer() {
        narratedQFromWord.getUserInput("house");
        assertTrue(narratedQFromWord.isCorrect());
    }

    @Test
    public void testGetUserInputIncorrectAnswer() {
        narratedQFromWord.getUserInput("incorrect answer");
        assertFalse(narratedQFromWord.isCorrect());
    }

    @Test
    public void testGetUserInputCaseInsensitive() {
        narratedQFromWord.getUserInput("HoUsE");
        assertTrue(narratedQFromWord.isCorrect());
    }

    @Test
    public void testPlaySoundWithWordPrompt() {
        narratedQFromWord.playSound();
        assertTrue(outContent.toString().contains("Playing sound for: casa"));
    }

    @Test
    public void testPlaySoundWithPhrasePrompt() {
        narratedQFromPhrase.playSound();
        assertTrue(outContent.toString().contains("Playing sound for: ¿Cómo estás?"));
    }

    @Test
    public void testToString() {
        String expected = "What does this mean in english? Please type in your response.";
        assertEquals(expected, narratedQFromWord.toString());
    }
}
