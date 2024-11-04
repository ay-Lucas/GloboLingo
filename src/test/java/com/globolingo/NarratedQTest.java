package com.globolingo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * JUnit test class for NarratedQ
 */
public class NarratedQTest {
    private NarratedQ narratedQ;
    private Word word;

    /**
     * Sets up a Word instance and initializes a NarratedQ object with it 
     * before each test.
     */
    @Before
    public void setUp() {
        word = new Word(Language.SPANISH, "hello", "hola", "greeting");
        narratedQ = new NarratedQ(word);
    }

    /**
     * Tests that the NarratedQ object is initialized correctly with the 
     * given Word object.
     */
    @Test
    public void testInitialization() {
        assertEquals("hello", narratedQ.getAnswer());  // Check only the answer, as prompt is not accessible
        assertFalse(narratedQ.isCorrect());            // Confirm the correct status is initially false
    }

    /**
     * Tests that the getUserInput method correctly evaluates user input 
     * by setting the correct field based on whether the input matches 
     * the answer.
     */
    @Test
    public void testGetUserInput() {
        narratedQ.getUserInput("hello");
        assertTrue(narratedQ.isCorrect());

        narratedQ.getUserInput("wrong answer");
        assertFalse(narratedQ.isCorrect());
    }

    /**
     * Tests the playSound method by capturing console output to verify
     * that the expected message is printed, simulating sound playback.
     */
    @Test
    public void testPlaySound() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        narratedQ.playSound();
        assertTrue(outContent.toString().contains("...playing sound..."));

        System.setOut(System.out); // Reset the standard output
    }

    /**
     * Tests that the toString method returns the correct prompt format 
     * for the narrated question.
     */
    @Test
    public void testToString() {
        String expected = "What does this mean in english? Please type in your response.";
        assertEquals(expected, narratedQ.toString());
    }
}
