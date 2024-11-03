package com.globolingo;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the SystemFACADE class, validating account creation, login,
 * learning process, avatar management, and user data handling.
 * Ensures that SystemFACADE methods work as expected.
 * 
 * @author Jacob
 */
class SystemFACADETest {
    private SystemFACADE system;
    private static final String TEST_USERNAME = "testUser";
    private static final String TEST_PASSWORD = "testPass123";
    private static final String TEST_FIRSTNAME = "John";
    private static final String TEST_LASTNAME = "Doe";

    /**
     * Sets up a new SystemFACADE instance before each test.
     */
    @BeforeEach
    void setUp() {
        system = new SystemFACADE();
    }

    /**
     * Tests successful account creation and verifies the new user data.
     */
    @Test
    void testCreateAccountSuccess() {
        system.createAccount(TEST_USERNAME, TEST_PASSWORD, TEST_FIRSTNAME, TEST_LASTNAME);
        User currentUser = system.getCurrentUser();
        assertNotNull(currentUser);
        assertEquals(TEST_USERNAME, currentUser.getUsername());
        assertEquals(TEST_FIRSTNAME, currentUser.getFirstName());
    }

    /**
     * Tests successful login and confirms that the user is set as current.
     */
    @Test
    void testLoginSuccess() {
        system.createAccount(TEST_USERNAME, TEST_PASSWORD, TEST_FIRSTNAME, TEST_LASTNAME);
        system.logout();
        boolean loginResult = system.login(TEST_USERNAME, TEST_PASSWORD);
        assertTrue(loginResult);
        assertNotNull(system.getCurrentUser());
    }

    /**
     * Tests login with invalid credentials, ensuring it fails and no user is set.
     */
    @Test
    void testLoginWithInvalidCredentials() {
        boolean loginResult = system.login("wrongUser", "wrongPass");
        assertFalse(loginResult);
        assertNull(system.getCurrentUser());
    }

    /**
     * Tests that logout clears current user and course-related data.
     */
    @Test
    void testLogoutClearsCurrentUserAndCourseData() {
        system.createAccount(TEST_USERNAME, TEST_PASSWORD, TEST_FIRSTNAME, TEST_LASTNAME);
        system.logout();
        assertNull(system.getCurrentUser());
        assertNull(system.getCurrentCourse());
        assertNull(system.getCurrentLesson());
        assertNull(system.getCurrentQuestion());
    }

    /**
     * Tests that starting a learning session creates a new course.
     */
    @Test
    void testStartLearningCreatesNewCourse() {
        system.createAccount(TEST_USERNAME, TEST_PASSWORD, TEST_FIRSTNAME, TEST_LASTNAME);
        system.startLearning(Language.SPANISH);
        assertNotNull(system.getCurrentCourse());
        assertEquals(1, system.getCurrentUser().getLevel());
    }

    /**
     * Tests that attempting to start learning without login fails.
     */
    @Test
    void testStartLearningWithoutLogin() {
        system.startLearning(Language.SPANISH);
        assertNull(system.getCurrentCourse());
    }

    /**
     * Tests that user level calculation updates correctly after completing a lesson.
     */
    @Test
    void testUpdateUserLevelCalculation() {
        system.createAccount(TEST_USERNAME, TEST_PASSWORD, TEST_FIRSTNAME, TEST_LASTNAME);
        system.startLearning(Language.SPANISH);
        system.addCompletedLesson();
        assertEquals(1, system.getCurrentUser().getLevel());
    }

    /**
     * Tests setting an avatar for the user and verifies it is set successfully.
     */
    @Test
    void testSetUserAvatar() {
        system.createAccount(TEST_USERNAME, TEST_PASSWORD, TEST_FIRSTNAME, TEST_LASTNAME);
        system.setUserAvatar("Pencil Warrior");
        Avatar userAvatar = system.getUserAvatar();
        assertNotNull(userAvatar);
    }

    /**
     * Tests unlocking a new avatar and checks if it is added to the unlocked avatars list.
     */
    @Test
    void testUnlockAvatar() {
        system.createAccount(TEST_USERNAME, TEST_PASSWORD, TEST_FIRSTNAME, TEST_LASTNAME);
        system.unlockAvatar("Black Ninja");
        ArrayList<Avatar> unlockedAvatars = system.getUnlockedAvatars();
        assertFalse(unlockedAvatars.isEmpty());
    }

    /**
     * Tests removal of the current user and verifies that they can no longer log in.
     */
    @Test
    void testRemoveCurrentUser() {
        system.createAccount(TEST_USERNAME, TEST_PASSWORD, TEST_FIRSTNAME, TEST_LASTNAME);
        system.removeCurrentUser();
        boolean loginResult = system.login(TEST_USERNAME, TEST_PASSWORD);
        assertFalse(loginResult);
    }

    /**
     * Tests that continuing learning increments the user's level.
     */
    @Test
    void testContinueLearningIncreasesLevel() {
        system.createAccount(TEST_USERNAME, TEST_PASSWORD, TEST_FIRSTNAME, TEST_LASTNAME);
        system.startLearning(Language.SPANISH);
        int initialLevel = system.getCurrentUser().getLevel();
        system.continueLearning();
        assertTrue(system.getCurrentUser().getLevel() > initialLevel);
    }

    /**
     * Tests retrieval of user courses, ensuring they are stored and accessible.
     */
    @Test
    void testGetUserCourses() {
        system.createAccount(TEST_USERNAME, TEST_PASSWORD, TEST_FIRSTNAME, TEST_LASTNAME);
        system.startLearning(Language.SPANISH);
        ArrayList<Course> courses = system.getUserCourses();
        assertNotNull(courses);
        assertFalse(courses.isEmpty());
    }
}
