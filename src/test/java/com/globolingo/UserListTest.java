package com.globolingo;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * Tests for the UserList class, covering user management functions.
 */
public class UserListTest {
    private UserList userList;
    private User testUser;
    private final String testUserUsername = "test";
    private final String testUserPassword = "12345678";

    /**
     * Initializes UserList and a test user before each test.
     */
    @BeforeEach
    public void setup() {
        userList = UserList.getInstance();
        testUser = new User(testUserUsername, testUserPassword);
    }

    /**
     * Removes test user after each test
     */
    @AfterEach
    public void cleanUp() {
        userList.removeUser(testUser.getUsername());
    }

    /**
     * Tests retrieving the list of all users.
     */
    @Test
    public void testGetUsers() {
        int sizeBefore = userList.getUsers().size();
        userList.addUser(testUser);
        ArrayList<User> users = userList.getUsers();
        assertEquals(sizeBefore + 1, users.size(), "User list should contain another user");
        assertTrue(users.contains(testUser), "User list should contain the added user.");
    }

    /**
     * Tests the singleton instance of UserList.
     */
    @Test
    public void testGetInstance() {
        UserList instance1 = UserList.getInstance();
        UserList instance2 = UserList.getInstance();
        assertSame(instance1, instance2, "Both references should point to the same singleton instance.");
    }

    /**
     * Tests adding a user to UserList.
     */
    @Test
    public void testAddUser() {
        userList.addUser(testUser);
        boolean result = userList.getUser(testUser.getUsername()) != null;
        assertTrue(result);
    }

    /**
     * Tests retrieving a user by username.
     */
    @Test
    public void testGetUserByUsername() {
        userList.addUser(testUser);
        User user = userList.getUser(testUserUsername);
        assertEquals(testUser, user);
    }

    /**
     * Tests retrieving a user by UUID.
     */
    @Test
    public void testGetUserByUUID() {
        userList.addUser(testUser);
        User retrievedUser = userList.getUserByUUID(testUser.getUUID());
        assertNotNull(retrievedUser);
        assertEquals(testUser, retrievedUser);
    }

    /**
     * Tests adding a user with a duplicate UUID.
     */
    @Test
    public void testAddDuplicateUUID() {
        UUID sharedUUID = UUID.randomUUID();
        User userWithDuplicateUUID = new User("duplicate_user", "Duplicate12345", "John", "Smith", 1, sharedUUID,
                new Avatar(), new ArrayList<>());
        testUser.setUUID(sharedUUID);
        userList.addUser(testUser);
        assertFalse(userList.addUser(userWithDuplicateUUID));
    }

    /**
     * Tests removing a user by username.
     */
    @Test
    public void testRemoveUser() {
        userList.addUser(testUser);
        assertTrue(userList.removeUser(testUserUsername));
        assertNull(userList.getUser("john_doe"));
    }

    /**
     * Tests editing a user's details.
     */
    @Test
    public void testEditUser() {
        userList.addUser(testUser);
        testUser.setFirstName("Gavin");
        userList.editUser(testUser);
        assertEquals("Gavin", userList.getUser(testUserUsername).getFirstName());
    }

    /**
     * Tests logging in a user.
     */
    @Test
    public void testLogInUser() {
        userList.addUser(testUser);
        userList.logInUser(testUser);
        assertTrue(testUser.isLoggedIn());
    }

    /**
     * Tests logging out a user.
     */
    @Test
    public void testLogOutUser() {
        userList.addUser(testUser);
        userList.logInUser(testUser);
        userList.logOutUser(testUser);
        assertFalse(testUser.isLoggedIn());
    }

    /**
     * Tests saving user details after modification.
     */
    @Test
    public void testSaveUser() {
        userList.addUser(testUser);
        testUser.setFirstName("UpdatedName");
        testUser.setLevel(5);
        userList.saveUser(testUser);
        User savedUser = userList.getUser(testUserUsername);
        assertEquals("UpdatedName", savedUser.getFirstName());
        assertEquals(5, savedUser.getLevel());
    }

    /**
     * Tests retrieving a user's avatar by username.
     */
    @Test
    public void testGetAvatar() {
        userList.addUser(testUser);
        Avatar avatar = userList.getAvatar(testUserUsername);
        assertNotNull(avatar);
    }
}
