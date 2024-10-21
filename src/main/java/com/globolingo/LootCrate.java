package com.globolingo;

import java.util.ArrayList;
import java.util.Random;

public class LootCrate {
    private Avatar avatarLoot;

    public LootCrate() {
        avatarLoot = getRandomAvatar();
    }

    public Avatar openCrate() {
        return avatarLoot;
    }

    private Avatar getRandomAvatar() {
        AvatarManager manager = new AvatarManager();
        ArrayList<Avatar> avatars = manager.getCrateAvatars();
        Random random = new Random();
        int randomInt = random.nextInt(avatars.size());
        Avatar randomAvatar = avatars.get(randomInt);

        return randomAvatar;
    }
}
