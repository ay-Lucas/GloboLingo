package com.globolingo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Jacob
 */
class WordTest {
    /** An instance of Word to be used in the test cases. */
    private Word word;
    /** The language for testing, set to Spanish. */
    private Language language;

    /**
     * Sets up the test objects before each test method.
     * Initializes a Word object with specific attributes to be used in each test.
     */
    @BeforeEach
    void setUp() {
        // Initialize test objects
        language = Language.SPANISH;
        word = new Word(language, "dog", "perro", "animals");
    }

    /**
     * Tests the constructor of the Word class.
     * Verifies that the Word object is created correctly and all properties are set as expected.
     */
    @Test
    void testConstructor() {
        // Verify word created correctly
        assertNotNull(word, "Word object should not be null.");
        assertEquals(Language.SPANISH, word.getLanguage(), "Language should be SPANISH.");
        assertEquals("dog", word.getEnglishWord(), "English word should be 'dog'.");
        assertEquals("perro", word.getTranslation(), "Translation should be 'perro'.");
        assertEquals("animals", word.getSubject(), "Subject should be 'animals'.");
    }

    /**
     * Tests the getLanguage method of the Word class.
     * Asserts that the language property is returned correctly.
     */
    @Test 
    void testGetLanguage() {
        assertEquals(language, word.getLanguage(), "Language should match the initialized value.");
    }

    /**
     * Tests the getEnglishWord method of the Word class.
     * Asserts that the English word property is returned correctly.
     */
    @Test
    void testGetEnglishWord() {
        assertEquals("dog", word.getEnglishWord(), "English word should be 'dog'.");
    }

    /**
     * Tests the getTranslation method of the Word class.
     * Asserts that the translation property is returned correctly.
     */
    @Test
    void testGetTranslation() {
        assertEquals("perro", word.getTranslation(), "Translation should be 'perro'.");
    }

    /**
     * Tests the getSubject method of the Word class.
     * Asserts that the subject property is returned correctly.
     */
    @Test
    void testGetSubject() {
        assertEquals("animals", word.getSubject(), "Subject should be 'animals'.");
    }

    /**
     * Tests the toString method of the Word class.
     * Asserts that the toString output matches the expected formatted string.
     */
    @Test
    void testToString() {
        String expected = "\nEnglish world: dog\nTranslation word: perro\nSubject: animals\nLanguage: SPANISH\n";
        assertEquals(expected, word.toString(), "The toString output should match the expected format.");
    }
}
