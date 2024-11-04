package com.globolingo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

public class PhraseTest {
    private Phrase phrase;
    private ArrayList<String> translationList;

    @Before
    public void setUp() {
        translationList = new ArrayList<>(Arrays.asList("¿Cómo", "estás", "hoy?"));
        phrase = new Phrase(Language.SPANISH, "How are you today?", translationList, "Greetings");
    }

    @Test
    public void testInitialization() {
        assertEquals("How are you today?", phrase.getEnglishPhrase());
        assertEquals(Language.SPANISH, phrase.getLanguage());
        assertEquals("Greetings", phrase.getSubject());
        assertEquals(translationList, phrase.getTranslationList());
    }

    @Test
    public void testGetTranslationString() {
        String expectedTranslation = "¿Cómo estás hoy? ";
        assertEquals(expectedTranslation, phrase.getTranslationString());
    }

    @Test
    public void testToString() {
        String expectedString = "English phrase: How are you today?\n" +
                "Translated phrase: ¿Cómo estás hoy? \n" +
                "Subject: Greetings\n" +
                "Language: SPANISH\n";
        assertEquals(expectedString, phrase.toString());
    }

    @Test
    public void testGetTranslationStringWithEmptyTranslationList() {
        Phrase emptyPhrase = new Phrase(Language.SPANISH, "Hello", new ArrayList<>(), "Greeting");
        assertEquals("", emptyPhrase.getTranslationString());
    }

    @Test
    public void testModificationOfTranslationListReflectsInPhrase() {
        // Modify translation list directly
        translationList.set(0, "¿Qué tal");
        assertEquals("¿Qué tal estás hoy? ", phrase.getTranslationString());
    }
}
