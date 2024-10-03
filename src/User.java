package globolingo;

public class User  {
    private String username;
    private String firstName = "Globo";
    private String lastName = "Linguist";
    private String password;
    private int level;
    private Avatar avatar;
    private Course course;
    private UUID uuid;

    public User(String name, String password)  {
        // Will probably need to add firstName lastName to UML/constructor
    }
    
    public User(String name, String password, UUID uuid)  {

    }
    public Progress getProgress()  {

    }
    
    // Getters 
    public String getName()  { return this.username; }
    
    public Avatar getAvatar()  { return this.avatar; }

    public Course getCourse()  { return this.course; }

        // Following getters not in UML

    public String getFirstName()  { return this.firstName; }

    public String getLastName()  { return this.lastName; }

    public String getPassword()  { return this.password; }

    public int getLevel()  { return this.level; }

    public UUID getUUID()  { return this.uuid; }


    

    // Setters
    public void setLevel(int level)  {

    }

    public void setCourse(Course course)  {
        
    }

    public void setName(String name)  {

    }

        // Following setters not in UML

    public void setAvatar(Avatar avatar)  {

    }

    public void setFirstName(String firstName)  {

    }

    public void setLastName(String lastName)  {

    }

    public void setPassword(String password)  {

    }
    
    public void setUUID(UUID uuid)  {

    }
}