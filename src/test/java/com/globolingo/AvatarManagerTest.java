package com.globolingo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the AvatarManager class.
 */
public class AvatarManagerTest {

    private AvatarManager avatarManager;

    /**
     * Initializes a new AvatarManager instance before each test.
     */
    @BeforeEach
    public void setup() {
        avatarManager = new AvatarManager();
    }

    /**
     * Tests the getDefaultAvatars method to ensure it returns only default avatars.
     */
    @Test
    public void testGetDefaultAvatars() {
        ArrayList<Avatar> defaultAvatars = avatarManager.getDefaultAvatars();

        assertNotNull(defaultAvatars, "Default avatars list should not be null");
        assertTrue(defaultAvatars.size() > 0, "Default avatars list should contain items");

        for (Avatar avatar : defaultAvatars) {
            assertTrue(avatar.isDefault(), "All avatars in default list should have isDefault set to true");
        }
    }

    /**
     * Tests the getCrateAvatars method to ensure it returns only loot crate
     * avatars.
     */
    @Test
    public void testGetCrateAvatars() {
        ArrayList<Avatar> crateAvatars = avatarManager.getCrateAvatars();

        assertNotNull(crateAvatars, "Crate avatars list should not be null");
        assertTrue(crateAvatars.size() > 0, "Crate avatars list should contain items");

        for (Avatar avatar : crateAvatars) {
            assertFalse(avatar.isDefault(), "All avatars in crate list should have isDefault set to false");
        }
    }

    /**
     * Tests the getAllAvatars method to ensure it returns all avatars.
     */
    @Test
    public void testGetAllAvatars() {
        ArrayList<Avatar> allAvatars = avatarManager.getAllAvatars();

        assertNotNull(allAvatars, "All avatars list should not be null");

        int expectedSize = avatarManager.getDefaultAvatars().size() + avatarManager.getCrateAvatars().size();
        assertEquals(expectedSize, allAvatars.size(),
                "All avatars list size should match total of default and crate avatars");
    }

    /**
     * Tests the getAvatar method to ensure it returns the correct avatar by name.
     */
    @Test
    public void testGetAvatarByName() {
        Avatar avatar = avatarManager.getAvatar("Pencil Warrior");

        assertNotNull(avatar, "Avatar with name 'Pencil Warrior' should not be null");
        assertEquals("Pencil Warrior", avatar.getName(), "Avatar name should be 'Pencil Warrior'");
    }

    /**
     * Tests the getAvatar method to ensure it returns a default avatar if the name
     * does not match any avatar.
     */
    @Test
    public void testGetAvatarByNameNotFound() {
        Avatar avatar = avatarManager.getAvatar("Nonexistent Avatar");

        assertNotNull(avatar, "Returned avatar should not be null");
        assertEquals("default", avatar.getName(), "Avatar name should default to 'default' when not found");
        assertEquals("default", avatar.getPath(), "Avatar path should default to 'default' when not found");
        assertTrue(avatar.isDefault(), "Returned avatar should have isDefault set to true when not found");
    }
}
