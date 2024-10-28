package com.globolingo;

import java.util.ArrayList;
import java.util.Random;

/**
 * LootCrate class generates a random Avatar for a User to open
 */
public class LootCrate {
    private Avatar avatarLoot;

    /**
     * Creates a Loot Crate and instantiates the avatarLoot with a random Avatar
     */
    public LootCrate() {
        avatarLoot = getRandomAvatar();
    }

    /**
     * Returns an Avatar randomly generated from LootCrate
     * 
     * @return random Avatar
     */
    public Avatar openCrate() {
        return avatarLoot;
    }

    /**
     * Gets a random avatar
     * 
     * @return a random Avatar
     */
    private Avatar getRandomAvatar() {
        AvatarManager manager = new AvatarManager();
        ArrayList<Avatar> avatars = manager.getCrateAvatars();
        Random random = new Random();
        int randomInt = random.nextInt(avatars.size());
        Avatar randomAvatar = avatars.get(randomInt);

        return randomAvatar;
    }
}
