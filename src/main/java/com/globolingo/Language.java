package com.globolingo;
public enum Language  {
    SPANISH,
    JAPANESE,
    GERMAN,
    ITALIAN,
    FRENCH;

    public String getLanguage()  {
        switch (this) {
            case SPANISH:
                return "SPANISH";
            case JAPANESE:
                return "JAPANESE";
            case GERMAN:
                return "GERMAN";
            case ITALIAN:
                return "ITALIAN";
            case FRENCH:
                return "FRENCH";
            default:
                throw new IllegalArgumentException("Unknown language: " + this);
        }
    }
}
