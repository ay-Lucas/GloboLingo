package com.globolingo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * AvatarManager for loading and getting avatars
 * 
 * @author Lucas A
 */
public class AvatarManager {

    private List<Avatar> avatars = new ArrayList<>();
    private final String PATH_BASE = "./src/main/resources";

    /**
     * Creates a new AvatarManager
     */
    public AvatarManager() {
        // Initialize avatars
        loadDefaultAvatars();
        loadCrateAvatars();
    }

    /**
     * Adds default avatars to avatars ArrayList
     */
    private void loadDefaultAvatars() {
        avatars.add(new Avatar("Pencil Warrior", PATH_BASE + "Pencil Warrior", true));
        avatars.add(new Avatar("Potato Rider", PATH_BASE + "Potato Rider", true));
        avatars.add(new Avatar("Basic Bobby", PATH_BASE + "Basic Bobby", true));
        avatars.add(new Avatar("Generic Guy", PATH_BASE + "Generic Guy", true));
        avatars.add(new Avatar("Black Ninja", PATH_BASE + "Black Ninja", true));
        avatars.add(new Avatar("Tired Tiger", PATH_BASE + "Tired Tiger", true));
        avatars.add(new Avatar("Unremarkable Ray", PATH_BASE + "Unremarkable Ray", true));
        avatars.add(new Avatar("Chill Crusader", PATH_BASE + "Chill Crusader", true));
        avatars.add(new Avatar("Bland Bandit", PATH_BASE + "Bland Bandit", true));
        avatars.add(new Avatar("Unfinished Quest", PATH_BASE + "Unfinished Quest", true));
        avatars.add(new Avatar("Paper Sword", PATH_BASE + "Paper Sword", true));
        avatars.add(new Avatar("Monkey Fartking", PATH_BASE + "Monkey Fartking", true));
    }

    /**
     * Adds loot crate avatars to avatars ArrayList
     */
    private void loadCrateAvatars() {
        avatars.add(new Avatar("Keyboard Warrior", PATH_BASE + "Keyboard Warrior", false));
        avatars.add(new Avatar("Shadow Wing", PATH_BASE + "Shadow Wing", false));
        avatars.add(new Avatar("Fire Storm", PATH_BASE + "Fire Storm", false));
        avatars.add(new Avatar("Star Hunter", PATH_BASE + "Star Hunter", false));
        avatars.add(new Avatar("Iron Fang", PATH_BASE + "Iron Fang", false));
        avatars.add(new Avatar("Night Blade", PATH_BASE + "Night Blade", false));
        avatars.add(new Avatar("Frost Wolf", PATH_BASE + "Frost Wolf", false));
        avatars.add(new Avatar("Dark Flame", PATH_BASE + "Dark Flame", false));
        avatars.add(new Avatar("Sky Rider", PATH_BASE + "Sky Rider", false));
        avatars.add(new Avatar("Stone Fist", PATH_BASE + "Stone Fist", false));
        avatars.add(new Avatar("Red Eagle", PATH_BASE + "Red Eagle", false));
        avatars.add(new Avatar("Storm Runner", PATH_BASE + "Storm Runner", false));
        avatars.add(new Avatar("Iron Claw", PATH_BASE + "Iron Claw", false));
        avatars.add(new Avatar("Moon Shade", PATH_BASE + "Moon Shade", false));
        avatars.add(new Avatar("Thunder Strike", PATH_BASE + "Thunder Strike", false));
        avatars.add(new Avatar("Blaze Wing", PATH_BASE + "Blaze Wing", false));
        avatars.add(new Avatar("Blue Hawk", PATH_BASE + "Blue Hawk", false));
        avatars.add(new Avatar("Earth Guard", PATH_BASE + "Earth Guard", false));
        avatars.add(new Avatar("Wind Chaser", PATH_BASE + "Wind Chaser", false));
        avatars.add(new Avatar("Flame Heart", PATH_BASE + "Flame Heart", false));
        avatars.add(new Avatar("Night Warden", PATH_BASE + "Night Warden", false));
        avatars.add(new Avatar("Ice Claw", PATH_BASE + "Ice Claw", false));
        avatars.add(new Avatar("Steel Horn", PATH_BASE + "Steel Horn", false));
        avatars.add(new Avatar("Solar Hawk", PATH_BASE + "Solar Hawk", false));
        avatars.add(new Avatar("Dark Warden", PATH_BASE + "Dark Warden", false));
        avatars.add(new Avatar("Frost Blade", PATH_BASE + "Frost Blade", false));
        avatars.add(new Avatar("Wind Shadow", PATH_BASE + "Wind Shadow", false));
        avatars.add(new Avatar("Rock Fang", PATH_BASE + "Rock Fang", false));
        avatars.add(new Avatar("Fire Fist", PATH_BASE + "Fire Fist", false));
        avatars.add(new Avatar("Night Flare", PATH_BASE + "Night Flare", false));
        avatars.add(new Avatar("Sky Blade", PATH_BASE + "Sky Blade", false));
        avatars.add(new Avatar("Steel Wolf", PATH_BASE + "Steel Wolf", false));
        avatars.add(new Avatar("Iron Wing", PATH_BASE + "Iron Wing", false));
        avatars.add(new Avatar("Ice Hunter", PATH_BASE + "Ice Hunter", false));
        avatars.add(new Avatar("Thunder Claw", PATH_BASE + "Thunder Claw", false));
        avatars.add(new Avatar("Dark Blade", PATH_BASE + "Dark Blade", false));
        avatars.add(new Avatar("Stone Guard", PATH_BASE + "Stone Guard", false));
        avatars.add(new Avatar("Fire Hawk", PATH_BASE + "Fire Hawk", false));
        avatars.add(new Avatar("Red Wolf", PATH_BASE + "Red Wolf", false));
        avatars.add(new Avatar("Shadow Strike", PATH_BASE + "Shadow Strike", false));
        avatars.add(new Avatar("Storm Wing", PATH_BASE + "Storm Wing", false));
        avatars.add(new Avatar("Sky Flame", PATH_BASE + "Sky Flame", false));
        avatars.add(new Avatar("Blue Faang", PATH_BASE + "Blue Faang", false));
        avatars.add(new Avatar("Night Rider", PATH_BASE + "Night Rider", false));
        avatars.add(new Avatar("Wind Blade", PATH_BASE + "Wind Blade", false));
        avatars.add(new Avatar("Rock Storm", PATH_BASE + "Rock Storm", false));
        avatars.add(new Avatar("Flame Claw", PATH_BASE + "Flame Claw", false));
        avatars.add(new Avatar("Earth Wing", PATH_BASE + "Earth Wing", false));
        avatars.add(new Avatar("Ice Shade", PATH_BASE + "Ice Shade", false));
        avatars.add(new Avatar("Thunder Wing", PATH_BASE + "Thunder Wing", false));
        avatars.add(new Avatar("Dark Storm", PATH_BASE + "Dark Storm", false));
    }

    /**
     * Gets default avatars
     * 
     * @return ArrayList of default avatars
     */
    public ArrayList<Avatar> getDefaultAvatars() {
        ArrayList<Avatar> defaultAvatars = new ArrayList<>();
        for (Avatar avatar : avatars) {
            if (avatar.isDefault()) {
                defaultAvatars.add(avatar);
            }
        }
        return defaultAvatars;
    }

    /**
     * Gets loot crate avatars
     * 
     * @return ArrayList of loot crate avatars
     */
    public ArrayList<Avatar> getCrateAvatars() {
        ArrayList<Avatar> crateAvatars = new ArrayList<>();
        for (Avatar avatar : avatars) {
            if (!avatar.isDefault()) {
                crateAvatars.add(avatar);
            }
        }
        return crateAvatars;
    }

    /**
     * Get all avatars
     * 
     * @return ArrayList of loot crate avatars
     */
    public ArrayList<Avatar> getAllAvatars() {
        ArrayList<Avatar> availableAvatars = new ArrayList<>();
        availableAvatars.addAll(getCrateAvatars());
        availableAvatars.addAll(getDefaultAvatars());
        return availableAvatars;
    }

    /**
     * Gets avatar with matching name by iterating over all avatars contained in the
     * avatar list
     * 
     * @param name of Avatar
     * @return null or Avatar
     */
    public Avatar getAvatar(String name) {
        Iterator<Avatar> iterator = avatars.iterator();
        while (iterator.hasNext()) {
            Avatar next = iterator.next();
            if (next.getName().equals(name)) {
                return next;
            }
        }
        return new Avatar();
    }
}
