package globolingo;

import java.util.ArrayList;

public class Avatar  {

    private Item hat;
    private Item face;
    private Item body;
    private Item cape;
        // listed as List<Item> in UML, should be arraylist?
    private ArrayList<Item> unlockedItems;

    public Avatar(Item hat, Item face, Item body, Item cape)  {

    }

        // No getters in UML adding here
    public Item getHat()  { return this.hat; }
    
    public Item getFace()  { return this.face; }

    public Item getBody()  { return this.body; }

    public Item getCape()  { return this.cape; }

        // No setters in UML, adding here
    public void setHat(Item hat)  {

    }

    public void setFace(Item face)  {

    }

    public void setBody(Item body)  {

    }

    public void setCape(Item cape)  {

    }

    public void customizeAvatar(Item hat, Item face, Item body, Item cape)  {

    }
    
    public void unlockItem(Item item)  {

    }

    public ArrayList<Item> viewUnlockedItems() { return this.unlockedItems; }

    public void equipItem(Item item)  {

    }

    public String getAvatarDetails() {
        
    }

    
}