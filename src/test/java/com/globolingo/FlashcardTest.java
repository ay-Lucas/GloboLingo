package com.globolingo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test class for Flashcard
 */
public class FlashcardTest {
    private Flashcard flashcard;
    private Word word;

    /**
     * Sets up a Word instance and initializes a Flashcard object with it 
     * before each test.
     */
    @Before
    public void setUp() {
        word = new Word(Language.SPANISH, "hello", "hola", "greeting");
        flashcard = new Flashcard(word);
    }

    /**
     * Tests that the Flashcard is initialized correctly with the given Word object.
     */
    @Test
    public void testInitialization() {
        assertEquals("hola", flashcard.getPrompt());
        assertEquals("hello", flashcard.getAnswer());
        assertFalse(flashcard.isCorrect());
    }

    /**
     * Tests that the getUserInput method correctly evaluates user input 
     * by setting the correct field based on whether the input matches 
     * the expected answer.
     */
    @Test
    public void testGetUserInput() {
        flashcard.getUserInput("hello");
        assertTrue(flashcard.isCorrect());

        flashcard.getUserInput("wrong answer");
        assertFalse(flashcard.isCorrect());
    }

    /**
     * Tests that the toString method returns the correct question format 
     * for the flashcard prompt.
     */
    @Test
    public void testToString() {
        String expected = "What does \"hola\" mean in English?";
        assertEquals(expected, flashcard.toString());
    }
}
