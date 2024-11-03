package com.globolingo;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for DataWriter, testing the functionality of saving user data,
 * including user information, courses, and avatar settings, to persistent storage.
 * These tests verify data integrity by loading data back through DataLoader.
 * 
 * @author Jacob
 */
class DataWriterTest extends DataConstants {
    
    private ArrayList<User> testUsers;
    private User testUser;
    
    /**
     * Set up the test environment by creating a test user with standard credentials
     * and adding it to the testUsers list before each test.
     */
    @BeforeEach
    void setUp() {
        testUsers = new ArrayList<>();
        // Create a test user with standard credentials
        testUser = new User("testUsername", "testPassword");
        testUser.setFirstName("TestFirst");
        testUser.setLastName("TestLast");
        testUser.setLevel(1);
        testUsers.add(testUser);
    }

    /**
     * Test to verify that saving a user list is successful.
     * Asserts that DataWriter.saveUserList returns true and the saved data is retrievable.
     */
    @Test
    void testSaveUserListSuccess() {
        boolean result = DataWriter.saveUserList(testUsers);
        assertTrue(result);
        
        // Verify saved data through DataLoader
        ArrayList<User> loadedUsers = DataLoader.getUsers();
        assertNotNull(loadedUsers);
        assertTrue(loadedUsers.size() > 0);
    }

    /**
     * Test to ensure that the saved user data retains integrity after loading,
     * matching the originally saved values for username, first name, last name, and level.
     */
    @Test
    void testUserDataIntegrity() {
        DataWriter.saveUserList(testUsers);
        ArrayList<User> loadedUsers = DataLoader.getUsers();
        
        User savedUser = null;
        for(User user : loadedUsers) {
            if(user.getUsername().equals(testUser.getUsername())) {
                savedUser = user;
                break;
            }
        }
        
        assertNotNull(savedUser);
        assertEquals(testUser.getUsername(), savedUser.getUsername());
        assertEquals(testUser.getFirstName(), savedUser.getFirstName());
        assertEquals(testUser.getLastName(), savedUser.getLastName());
        assertEquals(testUser.getLevel(), savedUser.getLevel());
    }

    /**
     * Test to verify that a user with courses is saved correctly.
     * Assumes that the default course for the user is in Spanish.
     */
    @Test
    void testSaveUserWithCourses() {
        DataWriter.saveUserList(testUsers);
        ArrayList<User> loadedUsers = DataLoader.getUsers();
        
        User savedUser = null;
        for(User user : loadedUsers) {
            if(user.getUsername().equals(testUser.getUsername())) {
                savedUser = user;
                break;
            }
        }
        
        assertNotNull(savedUser);
        assertFalse(savedUser.getCourseList().isEmpty());
        assertEquals(Language.SPANISH, savedUser.getCourseList().get(0).getLanguage());
    }

    /**
     * Test to verify that a user's avatar is saved correctly.
     * Assumes the default avatar for the user is set to "default".
     */
    @Test
    void testSaveUserWithAvatar() {
        // Default avatar is set in User constructor
        DataWriter.saveUserList(testUsers);
        ArrayList<User> loadedUsers = DataLoader.getUsers();
        
        User savedUser = null;
        for(User user : loadedUsers) {
            if(user.getUsername().equals(testUser.getUsername())) {
                savedUser = user;
                break;
            }
        }
        
        assertNotNull(savedUser);
        assertNotNull(savedUser.getAvatar());
        assertEquals("default", savedUser.getAvatar().getName());
    }

    /**
     * Test to verify that multiple users can be saved successfully.
     * Checks if the saved user count is at least 2 after saving.
     */
    @Test
    void testSaveMultipleUsers() {
        User secondUser = new User("secondUser", "password123");
        testUsers.add(secondUser);
        
        boolean result = DataWriter.saveUserList(testUsers);
        assertTrue(result);
        
        ArrayList<User> loadedUsers = DataLoader.getUsers();
        assertTrue(loadedUsers.size() >= 2);
    }
}
