package com.globolingo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class LanguageTest {

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
