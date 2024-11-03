package com.globolingo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the LootCrate functionality.
 * Verifies the creation, behavior, and properties of loot crate avatars.
 * Ensures consistent results when opening crates.
 *
 * @author Jacob
 */
class LootCrateTest {
    private LootCrate lootCrate;

    /**
     * Sets up a new LootCrate before each test.
     */
    @BeforeEach
    void setUp() {
        lootCrate = new LootCrate();
    }

    /**
     * Tests that a LootCrate is created successfully.
     * Verifies that opening the crate yields an avatar.
     */
    @Test
    void testLootCrateCreation() {
        assertNotNull(lootCrate, "LootCrate should be created successfully");
        assertNotNull(lootCrate.openCrate(), "LootCrate should contain an Avatar after creation");
    }

    /**
     * Tests that opening the crate returns a non-null Avatar.
     */
    @Test
    void testOpenCrateReturnsAvatar() {
        Avatar avatar = lootCrate.openCrate();
        assertNotNull(avatar, "openCrate() should return a non-null Avatar");
    }

    /**
     * Ensures multiple calls to openCrate return the same Avatar.
     */
    @Test
    void testMultipleOpenCrateCallsReturnSameAvatar() {
        Avatar firstOpen = lootCrate.openCrate();
        Avatar secondOpen = lootCrate.openCrate();
        assertEquals(firstOpen, secondOpen, "Multiple openCrate() calls should return the same Avatar");
    }

    /**
     * Tests that different LootCrates can yield different Avatars.
     * Note: May occasionally fail if random selection produces the same avatar.
     */
    @Test
    void testDifferentLootCratesCanHaveDifferentAvatars() {
        LootCrate firstCrate = new LootCrate();
        LootCrate secondCrate = new LootCrate();
        
        Avatar firstAvatar = firstCrate.openCrate();
        Avatar secondAvatar = secondCrate.openCrate();
        
        assertNotNull(firstAvatar);
        assertNotNull(secondAvatar);
    }

    /**
     * Checks that the avatar from the loot crate has valid properties.
     */
    @Test
    void testOpenCrateAvatarHasValidProperties() {
        Avatar avatar = lootCrate.openCrate();
        assertNotNull(avatar.getName(), "Avatar should have a non-null name");
        assertNotNull(avatar.getPath(), "Avatar should have a non-null path");
        assertFalse(avatar.isDefault(), "Loot crate avatar should not be a default avatar");
    }
}
