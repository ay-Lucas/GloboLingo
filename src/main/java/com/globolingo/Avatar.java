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
     * Default contstructor for Avatar
     */
    public Avatar() {
        this.name = "default";
        this.path = "default";
        this.isDefault = true;
    }

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

    public String toString() {
        return "\nname: " + name + "\npath:" + path + "\nisDefault: " + isDefault;
    }

    /**
     * Checks if another avatar is equal to this instance
     * 
     * @param avatar
     * @return true or false if avatar is the same
     */
    public boolean equals(Avatar avatar) {
        return name == avatar.name && path == avatar.path && isDefault == avatar.isDefault;
    }
}
