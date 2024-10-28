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
    private final String RESOURCES_PATH = "./src/main/resources";
    private final String DEFAULT_AVATAR_DIR = "/default_avatar/";
    private final String LOOT_CRATE_AVATAR_DIR = "/loot_crate_avatar/";

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
        avatars.add(new Avatar("Pencil Warrior", RESOURCES_PATH + DEFAULT_AVATAR_DIR + "Pencil Warrior", true));
        avatars.add(new Avatar("Potato Rider", RESOURCES_PATH + DEFAULT_AVATAR_DIR + "Potato Rider", true));
        avatars.add(new Avatar("Basic Bobby", RESOURCES_PATH + DEFAULT_AVATAR_DIR + "Basic Bobby", true));
        avatars.add(new Avatar("Generic Guy", RESOURCES_PATH + DEFAULT_AVATAR_DIR + "Generic Guy", true));
        avatars.add(new Avatar("Black Ninja", RESOURCES_PATH + DEFAULT_AVATAR_DIR + "Black Ninja", true));
        avatars.add(new Avatar("Tired Tiger", RESOURCES_PATH + DEFAULT_AVATAR_DIR + "Tired Tiger", true));
        avatars.add(new Avatar("Unremarkable Ray", RESOURCES_PATH + DEFAULT_AVATAR_DIR + "Unremarkable Ray", true));
        avatars.add(new Avatar("Chill Crusader", RESOURCES_PATH + DEFAULT_AVATAR_DIR + "Chill Crusader", true));
        avatars.add(new Avatar("Bland Bandit", RESOURCES_PATH + DEFAULT_AVATAR_DIR + "Bland Bandit", true));
        avatars.add(new Avatar("Unfinished Quest", RESOURCES_PATH + DEFAULT_AVATAR_DIR + "Unfinished Quest", true));
        avatars.add(new Avatar("Paper Sword", RESOURCES_PATH + DEFAULT_AVATAR_DIR + "Paper Sword", true));
        avatars.add(new Avatar("Monkey Fartking", RESOURCES_PATH + DEFAULT_AVATAR_DIR + "Monkey Fartking", true));
    }

    /**
     * Adds loot crate avatars to avatars ArrayList
     */
    private void loadCrateAvatars() {
        avatars.add(new Avatar("Keyboard Warrior", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Keyboard Warrior", false));
        avatars.add(new Avatar("Shadow Wing", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Shadow Wing", false));
        avatars.add(new Avatar("Fire Storm", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Fire Storm", false));
        avatars.add(new Avatar("Star Hunter", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Star Hunter", false));
        avatars.add(new Avatar("Iron Fang", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Iron Fang", false));
        avatars.add(new Avatar("Night Blade", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Night Blade", false));
        avatars.add(new Avatar("Frost Wolf", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Frost Wolf", false));
        avatars.add(new Avatar("Dark Flame", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Dark Flame", false));
        avatars.add(new Avatar("Sky Rider", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Sky Rider", false));
        avatars.add(new Avatar("Stone Fist", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Stone Fist", false));
        avatars.add(new Avatar("Red Eagle", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Red Eagle", false));
        avatars.add(new Avatar("Storm Runner", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Storm Runner", false));
        avatars.add(new Avatar("Iron Claw", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Iron Claw", false));
        avatars.add(new Avatar("Moon Shade", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Moon Shade", false));
        avatars.add(new Avatar("Thunder Strike", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Thunder Strike", false));
        avatars.add(new Avatar("Blaze Wing", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Blaze Wing", false));
        avatars.add(new Avatar("Blue Hawk", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Blue Hawk", false));
        avatars.add(new Avatar("Earth Guard", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Earth Guard", false));
        avatars.add(new Avatar("Wind Chaser", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Wind Chaser", false));
        avatars.add(new Avatar("Flame Heart", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Flame Heart", false));
        avatars.add(new Avatar("Night Warden", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Night Warden", false));
        avatars.add(new Avatar("Ice Claw", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Ice Claw", false));
        avatars.add(new Avatar("Steel Horn", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Steel Horn", false));
        avatars.add(new Avatar("Solar Hawk", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Solar Hawk", false));
        avatars.add(new Avatar("Dark Warden", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Dark Warden", false));
        avatars.add(new Avatar("Frost Blade", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Frost Blade", false));
        avatars.add(new Avatar("Wind Shadow", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Wind Shadow", false));
        avatars.add(new Avatar("Rock Fang", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Rock Fang", false));
        avatars.add(new Avatar("Fire Fist", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Fire Fist", false));
        avatars.add(new Avatar("Night Flare", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Night Flare", false));
        avatars.add(new Avatar("Sky Blade", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Sky Blade", false));
        avatars.add(new Avatar("Steel Wolf", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Steel Wolf", false));
        avatars.add(new Avatar("Iron Wing", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Iron Wing", false));
        avatars.add(new Avatar("Ice Hunter", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Ice Hunter", false));
        avatars.add(new Avatar("Thunder Claw", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Thunder Claw", false));
        avatars.add(new Avatar("Dark Blade", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Dark Blade", false));
        avatars.add(new Avatar("Stone Guard", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Stone Guard", false));
        avatars.add(new Avatar("Fire Hawk", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Fire Hawk", false));
        avatars.add(new Avatar("Red Wolf", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Red Wolf", false));
        avatars.add(new Avatar("Shadow Strike", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Shadow Strike", false));
        avatars.add(new Avatar("Storm Wing", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Storm Wing", false));
        avatars.add(new Avatar("Sky Flame", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Sky Flame", false));
        avatars.add(new Avatar("Blue Faang", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Blue Faang", false));
        avatars.add(new Avatar("Night Rider", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Night Rider", false));
        avatars.add(new Avatar("Wind Blade", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Wind Blade", false));
        avatars.add(new Avatar("Rock Storm", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Rock Storm", false));
        avatars.add(new Avatar("Flame Claw", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Flame Claw", false));
        avatars.add(new Avatar("Earth Wing", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Earth Wing", false));
        avatars.add(new Avatar("Ice Shade", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Ice Shade", false));
        avatars.add(new Avatar("Thunder Wing", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Thunder Wing", false));
        avatars.add(new Avatar("Dark Storm", RESOURCES_PATH + LOOT_CRATE_AVATAR_DIR + "Dark Storm", false));
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
