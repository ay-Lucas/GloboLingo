package com.globolingo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuestionTest {
    private Question testQuestion;

    @BeforeEach
    void setUp() {
        // Create concrete implementation for testing
        testQuestion = new Question() {
            private boolean correct = false;
            private String answer = "test answer";
            
            @Override
            public boolean isCorrect() {
                return correct;
            }

            @Override
            public void getUserInput(String input) {
                correct = input.equals(answer);
            }

            @Override
            public String getAnswer() {
                return answer;
            }
        };
    }

    @Test
    void testIsCorrectInitialState() {
        assertFalse(testQuestion.isCorrect());
    }

    @Test
    void testGetUserInputCorrect() {
        testQuestion.getUserInput("test answer");
        assertTrue(testQuestion.isCorrect());
    }

    @Test
    void testGetUserInputIncorrect() {
        testQuestion.getUserInput("wrong answer");
        assertFalse(testQuestion.isCorrect());
    }

    @Test
    void testGetAnswer() {
        assertEquals("test answer", testQuestion.getAnswer());
    }
}
