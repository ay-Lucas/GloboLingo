package com.globolingo;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the Course class, validating its constructors,
 * lesson generation, and various getters and setters.
 * These tests ensure that the Course class behaves as expected,
 * covering both normal and edge cases.
 * 
 * @author Jacob
 */
public class CourseTest {
    private Course course;
    private User testUser;
    private Language testLanguage;
    
    /**
     * Set up the test environment by initializing a Course object,
     * a test user, and a language before each test.
     */
    @BeforeEach
    void setUp() {
        testLanguage = Language.SPANISH;
        testUser = new User("testUsername", "SecureTestPassword123", "TestFirst", "TestLast", 1, null, null, null);
        course = new Course(testLanguage, testUser);
    }

    /**
     * Test the basic Course constructor, verifying that the object is created
     * with the correct language, user, completed lessons count, and lessons list.
     */
    @Test
    void testBasicConstructor() {
        assertNotNull(course);
        assertEquals(testLanguage, course.getLanguage());
        assertEquals(testUser, course.getUser());
        assertEquals(0, course.getCompletedLessons());
        assertNotNull(course.getLessons());
    }

    /**
     * Test the extended Course constructor, checking that the course
     * and its initial lesson are correctly initialized.
     */
    @Test
    void testExtendedConstructor() {
        Course extendedCourse = new Course(testLanguage, testUser, 0);
        assertNotNull(extendedCourse);
        assertNotNull(extendedCourse.getCurrentLesson());
        assertEquals(testLanguage, extendedCourse.getLanguage());
        assertEquals(testUser, extendedCourse.getUser());
    }

    /**
     * Test the generateLessons method to confirm that it creates
     * a list of 10 lessons for the course.
     */
    @Test
    void testGenerateLessons() {
        course.generateLessons();
        ArrayList<Lesson> lessons = course.getLessons();
        assertEquals(10, lessons.size());
    }

    /**
     * Test setting and getting the current lesson in the course,
     * verifying that the getCurrentLesson method returns the expected lesson.
     */
    @Test
    void testSetAndGetCurrentLesson() {
        Lesson newLesson = new Lesson(1);
        course.setCurrentLesson(newLesson);
        assertEquals(newLesson, course.getCurrentLesson());
    }

    /**
     * Test setting and getting the language for the course, ensuring
     * that the language updates and returns correctly.
     */
    @Test
    void testSetAndGetLanguage() {
        Language newLanguage = Language.FRENCH;
        course.setLanguage(newLanguage);
        assertEquals(newLanguage, course.getLanguage());
    }

    /**
     * Test setting and getting the user for the course, verifying
     * that the course's user is correctly updated and retrieved.
     */
    @Test
    void testSetAndGetUser() {
        User newUser = new User("newUser", "SecureNewPassword123", "New", "User", 2, null, null, null);
        course.setUser(newUser);
        assertEquals(newUser, course.getUser());
    }

    /**
     * Test the incrementCompletedLessons method to ensure that
     * the count of completed lessons is correctly incremented.
     */
    @Test
    void testCompletedLessonsCounter() {
        assertEquals(0, course.getCompletedLessons());
        course.incrementCompletedLessons();
        assertEquals(1, course.getCompletedLessons());
        course.incrementCompletedLessons();
        assertEquals(2, course.getCompletedLessons());
    }

    /**
     * Test the viewResults method to verify that it returns
     * the initial score (0) when no lessons have been completed.
     */
    @Test
    void testViewResults() {
        course.generateLessons();
        int initialScore = course.viewResults();
        assertEquals(0, initialScore);
    }

    /**
     * Test the getLessons method to ensure that it returns a non-null
     * list of lessons, even if no lessons have been generated yet.
     */
    @Test
    void testGetLessons() {
        ArrayList<Lesson> lessons = course.getLessons();
        assertNotNull(lessons);
    }

    /**
     * Test the doLesson method to verify that it starts a lesson
     * and sets the current lesson correctly.
     */
    @Test
    void testDoLesson() {
        Course course = new Course(testLanguage, testUser, 0);
        course.doLesson();
        assertNotNull(course.getCurrentLesson());
    }
    
    /**
     * Test the generateLessons method to check if it enforces
     * a maximum lesson limit of 10 lessons.
     */
    @Test
    void testMaxLessonsLimit() {
        course.generateLessons();
        assertEquals(10, course.getLessons().size());
    }
}
