package com.globolingo;

/**
 * An Avatar
 * 
 * @author Lucas A
 */
public class Avatar {
    private final String name;
    private final String path;
    private final boolean isDefault;

    /**
     * Creates a new Avatar
     * 
     * @param name
     * @param path
     * @param isDefault
     */
    public Avatar(String name, String path, boolean isDefault) {
        this.name = name;
        this.path = path;
        this.isDefault = isDefault;
    }

    /**
     * Returns true if Avatar isDefault
     * 
     * @return boolean
     */
    public boolean isDefault() {
        return isDefault;
    }

    /**
     * Gets path of Avatar
     * 
     * @return String path
     */
    public String getPath() {
        return path;
    }

    /**
     * Gets Java Name
     * 
     * @return String name
     */
    public String getName() {
        return name;
    }
}
