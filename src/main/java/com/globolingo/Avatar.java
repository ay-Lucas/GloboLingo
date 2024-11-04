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
     * Checks if another object is equal to this instance
     * 
     * @param obj
     * @return true or false if the obj is the same
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Avatar avatar = (Avatar) obj;

        return isDefault == avatar.isDefault &&
                (name == avatar.name || (name != null && name.equals(avatar.name))) &&
                (path == avatar.path || (path != null && path.equals(avatar.path)));
    }
}
