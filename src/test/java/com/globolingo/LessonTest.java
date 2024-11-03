package com.globolingo;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LessonTest {
    private Lesson lesson;
    private static final int TEST_LESSON_NUMBER = 1;
    
    @BeforeEach
    void setUp() {
        lesson = new Lesson(TEST_LESSON_NUMBER);
    }

    @Test
    void constructorShouldInitializeWithCorrectDefaults() {
        assertEquals(0, lesson.getUserScore());
        assertEquals(10, lesson.getMaxScore());
        assertFalse(lesson.getIsComplete());
        assertNotNull(lesson.getQuestions());
    }

    @Test
    void setNameShouldUpdateLessonName() {
        String testName = "Test Lesson";
        lesson.setName(testName);
        assertEquals(testName, lesson.getName());
    }

    @Test
    void setCompletionShouldUpdateCompletionStatus() {
        lesson.setCompletion(true);
        assertTrue(lesson.getIsComplete());
    }

    @Test
    void setQuestionsShouldUpdateQuestionsList() {
        ArrayList<Question> testQuestions = new ArrayList<>();
        Word testWord = new Word(Language.SPANISH, "hello", "hola", "basics");
        testQuestions.add(new Flashcard(testWord));
        
        lesson.setQuestions(testQuestions);
        assertEquals(testQuestions, lesson.getQuestions());
    }

    @Test
    void setUserScoreShouldUpdateScore() {
        int testScore = 5;
        lesson.setUserScore(testScore);
        assertEquals(testScore, lesson.getUserScore());
    }

    @Test
    void setMaxScoreShouldUpdateMaxScore() {
        int testMaxScore = 15;
        lesson.setMaxScore(testMaxScore);
        assertEquals(testMaxScore, lesson.getMaxScore());
    }

    @Test
    void addUserScoreShouldIncrementScore() {
        int initialScore = lesson.getUserScore();
        lesson.addUserScore();
        assertEquals(initialScore + 1, lesson.getUserScore());
    }

    @Test
    void setDifficultyShouldUpdateDifficulty() {
        int testDifficulty = 3;
        lesson.setDifficulty(testDifficulty);
        assertEquals(testDifficulty, lesson.getDifficulty());
    }

    @Test
    void generateQuestionsShouldCreateNineQuestions() {
        lesson.generateQuestions(TEST_LESSON_NUMBER);
        assertEquals(9, lesson.getQuestions().size());
    }

    @Test
    void generateQuestionsShouldCreateDifferentTypesOfQuestions() {
        lesson.generateQuestions(TEST_LESSON_NUMBER);
        ArrayList<Question> questions = lesson.getQuestions();
        
        boolean hasMultipleChoice = false;
        boolean hasSentenceBuild = false;
        boolean hasNarratedQ = false;
        boolean hasFlashcard = false;
        
        for (Question q : questions) {
            if (q instanceof MultipleChoice) hasMultipleChoice = true;
            if (q instanceof SentenceBuild) hasSentenceBuild = true;
            if (q instanceof NarratedQ) hasNarratedQ = true;
            if (q instanceof Flashcard) hasFlashcard = true;
        }
        
        assertTrue(hasMultipleChoice && hasSentenceBuild && hasNarratedQ && hasFlashcard);
    }

    @Test
    void generateQuestionsShouldHandleInvalidLessonNumber() {
        lesson.generateQuestions(-1);
        assertNotNull(lesson.getQuestions());
        assertFalse(lesson.getQuestions().isEmpty());
    }

    @Test
    void generateQuestionsShouldLoadAppropriateSubject() {
        lesson.generateQuestions(1); // basics
        assertNotNull(lesson.getQuestions());
        
        lesson.generateQuestions(2); // greetings
        assertNotNull(lesson.getQuestions());
        
        lesson.generateQuestions(3); // travel
        assertNotNull(lesson.getQuestions());
    }
}
