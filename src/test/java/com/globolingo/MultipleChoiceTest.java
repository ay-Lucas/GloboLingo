package com.globolingo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * JUnit test class for MultipleChoice, verifying functionality including 
 * initialization, user input evaluation, and string representation.
 */
public class MultipleChoiceTest {
    private MultipleChoice multipleChoice;
    private Word word;
    private ArrayList<String> options;

    /**
     * Sets up a Word instance and initializes a MultipleChoice object with 
     * options before each test.
     */
    @Before
    public void setUp() {
        word = new Word(Language.SPANISH, "hello", "hola", "greeting");
        options = new ArrayList<>();
        options.add("hola");
        options.add("adios");
        options.add("buenos dias");
        options.add("por favor");
        
        multipleChoice = new MultipleChoice(options, word);
    }

    /**
     * Tests that the MultipleChoice object is initialized correctly with 
     * the given Word object and options.
     */
    @Test
    public void testInitialization() {
        assertEquals("hola", multipleChoice.getAnswer());
        assertFalse(multipleChoice.isCorrect());
    }

    /**
     * Tests that the getUserInput method correctly evaluates user input by 
     * setting the correct field based on whether the input matches the answer.
     */
    @Test
    public void testGetUserInput() {
        multipleChoice.getUserInput("a"); // Should correspond to "hola"
        assertTrue(multipleChoice.isCorrect());

        multipleChoice.getUserInput("b"); // Should correspond to "adios"
        assertFalse(multipleChoice.isCorrect());
    }

    /**
     * Tests that the toString method returns the correct prompt format 
     * for the multiple-choice question.
     */
    @Test
    public void testToString() {
        String expected = "How do you say hello in SPANISH?\n A) hola\nB) adios\nC) buenos dias\nD) por favor";
        assertEquals(expected, multipleChoice.toString());
    }
}
