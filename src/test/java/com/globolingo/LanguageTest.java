package com.globolingo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class LanguageTest {
    
    @Test
    void testSpanishLanguageString() {
        Language language = Language.SPANISH;
        assertEquals("SPANISH", language.getLanguage());
    }

    @Test
    void testJapaneseLanguageString() {
        Language language = Language.JAPANESE;
        assertEquals("JAPANESE", language.getLanguage());
    }

    @Test
    void testGermanLanguageString() {
        Language language = Language.GERMAN;
        assertEquals("GERMAN", language.getLanguage());
    }

    @Test
    void testItalianLanguageString() {
        Language language = Language.ITALIAN;
        assertEquals("ITALIAN", language.getLanguage());
    }

    @Test
    void testFrenchLanguageString() {
        Language language = Language.FRENCH;
        assertEquals("FRENCH", language.getLanguage());
    }

    @Test
    void testEnumValues() {
        Language[] languages = Language.values();
        assertEquals(5, languages.length);
    }

    @Test
    void testEnumValueOf() {
        Language spanish = Language.valueOf("SPANISH");
        assertEquals(Language.SPANISH, spanish);
    }

    @Test
    void testInvalidEnumValueOf() {
        assertThrows(IllegalArgumentException.class, () -> {
            Language.valueOf("KOREAN");
        });
    }
}
