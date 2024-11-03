package com.globolingo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User testUser;
    private final String username = "testUser";
    private final String password = "testPassword";

    @BeforeEach
    public void setup() {
        testUser = new User(username, password);
    }

    /**
     * Tests setting an invalid username.
     */
    @Test
    public void testSetInvalidUsername() {
        Error error = assertThrows(Error.class, () -> testUser.setUsername("abc"));
        assertTrue(error.getMessage().contains("Invalid username length"));
    }

    /**
     * Tests setting an invalid password.
     */
    @Test
    public void testSetInvalidPassword() {
        Error error = assertThrows(Error.class, () -> testUser.setPassword("short"));
        assertTrue(error.getMessage().contains("Invalid password length"));
    }

    /**
     * Tests adding and retrieving unlocked avatars.
     */
    @Test
    public void testAddAndGetUnlockedAvatars() {
        Avatar avatar = new Avatar();
        testUser.addUnlockedAvatar(avatar);
        assertTrue(testUser.getUnlockedAvatars().contains(avatar));
    }

    /**
     * Tests adding and removing courses from the course list.
     */
    @Test
    public void testAddAndRemoveCourses() {
        Course course = new Course(Language.SPANISH, testUser);
        testUser.addCourse(course);
        assertTrue(testUser.getCourseList().contains(course));
        testUser.removeCourse(course);
        assertFalse(testUser.getCourseList().contains(course));
    }

    /**
     * Tests setting and getting the logged-in status.
     */
    @Test
    public void testSetAndGetLoggedIn() {
        testUser.setLoggedIn(true);
        assertTrue(testUser.isLoggedIn());
        testUser.setLoggedIn(false);
        assertFalse(testUser.isLoggedIn());
    }

    /**
     * Tests updating user details.
     */
    @Test
    public void testUpdateDetails() {
        Avatar newAvatar = new Avatar();
        ArrayList<Course> newCourses = new ArrayList<>();
        newCourses.add(new Course(Language.FRENCH, testUser));
        testUser.updateDetails("NewFirst", "NewLast", "NewPassword", 10, newAvatar, newCourses);

        assertEquals("NewFirst", testUser.getFirstName());
        assertEquals("NewLast", testUser.getLastName());
        assertEquals("NewPassword", testUser.getPassword());
        assertEquals(10, testUser.getLevel());
        assertEquals(newAvatar, testUser.getAvatar());
        assertEquals(newCourses, testUser.getCourseList());
    }

    /**
     * Tests the equals method by creating a similar and a different user.
     */
    @Test
    public void testEquals() {
        User identicalUser = new User(username, password);
        identicalUser.setUUID(testUser.getUUID());
        assertTrue(testUser.equals(identicalUser));

        User differentUser = new User("differentUser", "differentPassword");
        assertFalse(testUser.equals(differentUser));
    }

    /**
     * Tests the toString method to ensure output includes key fields.
     */
    @Test
    public void testToString() {
        String result = testUser.toString();
        assertTrue(result.contains(username));
        assertTrue(result.contains("Globo")); // Default first name
        assertTrue(result.contains("Linguist")); // Default last name
    }
}
