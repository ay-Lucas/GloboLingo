package com.globolingo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Test class for DataLoader. Verifies proper loading and parsing of users,
 * words and phrases from JSON files
 */
public class DataLoaderTest {

    private ArrayList<User> users;
    private ArrayList<Word> words;
    private ArrayList<Phrase> phrases;

    /**
     * Sets up test data by loading users, words, and phrases.
     */
    @Before
    public void setup() {
        users = DataLoader.getUsers();
        words = DataLoader.loadWords("basics");
        phrases = DataLoader.loadPhrases("basics");
    }

    /**
     * Tests user loading functionality including user fields, avatars, and courses.
     */
    @Test
    public void testGetUsers() {
        assertNotNull("Users list should not be null", users);
        assertFalse("Users list should not be empty", users.isEmpty());

        User firstUser = users.get(0);
        assertNotNull("First user should not be null", firstUser);
        assertNotNull("Username should not be null", firstUser.getUsername());
        assertNotNull("Password should not be null", firstUser.getPassword());
        assertNotNull("First name should not be null", firstUser.getFirstName());
        assertNotNull("Last name should not be null", firstUser.getLastName());
        assertTrue("Level should be positive", firstUser.getLevel() >= 0);
        assertNotNull("UUID should not be null", firstUser.getUUID());

        assertNotNull("Avatar should not be null", firstUser.getAvatar());
        assertNotNull("Unlocked avatars list should not be null", firstUser.getUnlockedAvatars());

        assertNotNull("Courses list should not be null", firstUser.getCourseList());
        assertFalse("Courses list should not be empty", firstUser.getCourseList().isEmpty());

        Course firstCourse = firstUser.getCourseList().get(0);
        assertNotNull("Course should not be null", firstCourse);
        assertNotNull("Course language should not be null", firstCourse.getLanguage());
        assertEquals("Course user should match", firstUser, firstCourse.getUser());
    }

    /**
     * Tests word loading functionality including translations and language
     * settings.
     */

    @Test
    public void testLoadWords() {
        assertNotNull("Words list should not be null", words);
        assertFalse("Words list should not be empty", words.isEmpty());

        Word firstWord = words.get(0);
        assertNotNull("Word should not be null", firstWord);
        assertNotNull("English word should not be null", firstWord.getEnglishWord());
        assertNotNull("Translated word should not be null", firstWord.getTranslation());
        assertEquals("Language should be Spanish", Language.SPANISH, firstWord.getLanguage());
        assertEquals("Subject should be basics", "basics", firstWord.getSubject());
    }

    /**
     * Tests phrase loading functionality including translations and language
     * settings.
     */
    @Test
    public void testLoadPhrases() {
        assertNotNull("Phrases list should not be null", phrases);
        assertFalse("Phrases list should not be empty", phrases.isEmpty());

        Phrase firstPhrase = phrases.get(0);
        assertNotNull("Phrase should not be null", firstPhrase);
        assertNotNull("English phrase should not be null", firstPhrase.getEnglishPhrase());
        assertNotNull("Translated string should not be null", firstPhrase.getTranslationString());
        assertNotNull("Translated words list should not be null", firstPhrase.getTranslationList());
        assertFalse("Translated words list should not be empty", firstPhrase.getTranslationList().isEmpty());
        assertEquals("Language should be Spanish", Language.SPANISH, firstPhrase.getLanguage());
        assertEquals("Subject should be basics", "basics", firstPhrase.getSubject());
    }

    /**
     * Tests word loading behavior with invalid subject input.
     */
    @Test
    public void testLoadWordsWithInvalidSubject() {
        ArrayList<Word> invalidWords = DataLoader.loadWords("nonexistent");
        assertNull("Words list should be null for invalid subject", invalidWords);
    }

    /**
     * Tests phrase loading behavior with invalid subject input.
     */
    @Test
    public void testLoadPhrasesWithInvalidSubject() {
        ArrayList<Phrase> invalidPhrases = DataLoader.loadPhrases("nonexistent");
        assertNull("Phrases list should be null for invalid subject", invalidPhrases);
    }
}
