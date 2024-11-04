package com.globolingo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Mock enum for Language in case the actual enum is unavailable.
 */
enum Language {
    SPANISH, FRENCH, GERMAN
}

/**
 * JUnit test class for the Phrase class, which tests Phrase functionality such as 
 * initialization, translation string formatting, toString representation, and 
 * behavior with an empty translation list.
 */
public class PhraseTest {
    private Phrase phrase;
    private ArrayList<String> translationList;

    /**
     * Sets up test data before each test case. Initializes a Phrase object 
     * and an ArrayList representing the translation of an English phrase.
     */
    @Before
    public void setUp() {
        translationList = new ArrayList<>(Arrays.asList("¿Cómo", "estás", "hoy?"));
        phrase = new Phrase(Language.SPANISH, "How are you today?", translationList, "Greetings");
    }

    /**
     * Tests that the Phrase object initializes correctly with provided values 
     * for language, English phrase, translation list, and subject.
     */
    @Test
    public void testInitialization() {
        assertEquals("How are you today?", phrase.getEnglishPhrase());
        assertEquals(Language.SPANISH, phrase.getLanguage());
        assertEquals("Greetings", phrase.getSubject());
        assertEquals(translationList, phrase.getTranslationList());
    }

    /**
     * Tests that getTranslationString returns the translated phrase as a 
     * single string with spaces between each word.
     */
    @Test
    public void testGetTranslationString() {
        String expectedTranslation = "¿Cómo estás hoy? ";
        assertEquals(expectedTranslation, phrase.getTranslationString());
    }

    /**
     * Tests that the toString method correctly formats and returns the 
     * Phrase object's details, including English phrase, translated phrase, 
     * subject, and language.
     */
    @Test
    public void testToString() {
        String expectedString = "English phrase: How are you today?\n" +
                "Translated phrase: ¿Cómo estás hoy? \n" +
                "Subject: Greetings\n" +
                "Language: SPANISH\n";
        assertEquals(expectedString, phrase.toString());
    }

    /**
     * Tests that getTranslationString returns an empty string when the 
     * translation list is empty.
     */
    @Test
    public void testGetTranslationStringWithEmptyTranslationList() {
        Phrase emptyPhrase = new Phrase(Language.SPANISH, "Hello", new ArrayList<>(), "Greeting");
        assertEquals("", emptyPhrase.getTranslationString());
    }

    /**
     * Tests that modifying the original translation list reflects in the 
     * Phrase object, ensuring it maintains a reference to the list rather 
     * than creating a copy.
     */
    @Test
    public void testModificationOfTranslationListReflectsInPhrase() {
        translationList.set(0, "¿Qué tal");
        assertEquals("¿Qué tal estás hoy? ", phrase.getTranslationString());
    }
}
