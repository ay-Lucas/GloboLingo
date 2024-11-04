package com.globolingo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Test Avatar class
 * 
 */
public class AvatarTest {

    /**
     * Tests the default constructor to ensure it sets the default values correctly
     */
    @Test
    public void testDefaultConstructor() {
        Avatar avatar = new Avatar();

        assertEquals("default", avatar.getName(), "Default name should be 'default'");
        assertEquals("default", avatar.getPath(), "Default path should be 'default'");
        assertTrue(avatar.isDefault(), "Default avatar should have isDefault set to true");
    }

    /**
     * Tests the parameterized constructor to ensure it sets all fields correctly
     */
    @Test
    public void testParameterizedConstructor() {
        String name = "Bland Bandit";
        String path = "./src/main/resources/default_avatar/" + name;

        Avatar avatar = new Avatar(name, path, false);

        assertEquals(name, avatar.getName(), "Name should match constructor parameter");
        assertEquals(path, avatar.getPath(), "Path should match constructor parameter");
        assertEquals(false, avatar.isDefault(), "isDefault should match constructor parameter");
    }

    /**
     * Tests the toString method to ensure it returns a properly formatted string
     */
    @Test
    public void testToString() {
        Avatar avatar = new Avatar("Test Avatar", "/test/path", false);
        String expected = "\nname: Test Avatar\npath:/test/path\nisDefault: false";

        assertEquals(expected, avatar.toString(), "toString should return correctly formatted string");
    }

    /**
     * Tests the equals method to ensure it returns true for identical avatars
     */
    @Test
    public void testEqualsWithIdenticalAvatars() {
        Avatar avatar1 = new Avatar("test", "/path", false);
        Avatar avatar2 = new Avatar("test", "/path", false);

        assertTrue(avatar1.equals(avatar2), "Identical avatars should be equal");
        assertTrue(avatar2.equals(avatar1), "Equals should be symmetric");
    }

    /**
     * Tests the equals method to ensure it returns false for avatars with different
     * fields
     */
    @Test
    public void testEqualsWithDifferentAvatars() {
        Avatar avatar1 = new Avatar("test1", "/path1", false);
        Avatar avatar2 = new Avatar("test2", "/path2", true);

        assertFalse(avatar1.equals(avatar2), "Different avatars should not be equal");
    }

    /**
     * Tests the equals method to ensure it returns false when compared with null or
     * a different object type
     */
    @Test
    public void testEqualsWithNullAndDifferentTypes() {
        Avatar avatar = new Avatar("test", "/path", false);

        assertFalse(avatar.equals(null), "Avatar should not be equal to null");
        assertFalse(avatar.equals("not an avatar"), "Avatar should not be equal to different object type");
    }

    /**
     * Tests the equals method to ensure it returns true when comparing the same
     * instance
     */
    @Test
    public void testEqualsWithSameInstance() {
        Avatar avatar = new Avatar("test", "/path", false);

        assertTrue(avatar.equals(avatar), "Avatar should be equal to itself");
    }

    /**
     * Tests the equals method to ensure it handles avatars with null name and path
     * fields
     */
    @Test
    public void testEqualsWithNullFields() {
        Avatar avatar1 = new Avatar(null, null, false);
        Avatar avatar2 = new Avatar(null, null, false);
        Avatar avatar3 = new Avatar("test", "/path", false);

        assertTrue(avatar1.equals(avatar2), "Avatars with null fields should be considered equal");
        assertFalse(avatar1.equals(avatar3),
                "Avatar with null fields should not be equal to avatar with non-null fields");
    }
}
