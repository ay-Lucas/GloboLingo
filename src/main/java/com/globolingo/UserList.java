package com.globolingo;
import java.util.ArrayList;

public class UserList  {

    private ArrayList<User> users;
    private UserList userList;

    private UserList()  {

    }

    public UserList getInstance()  {

    }

    public User addUser(String username, String firstName, String lastName, 
        String password)  {

        }
    
        // following getters not present in UML, may be needed
    public ArrayList<User> getUsers()  { return this.users; }

    public UserList getUserListInstance()  { return this.userList; }

    public User getUser(String username)  {

    }
    
    public void editUser()  {

    }
    public void logOutUser()  {

    }
    public void saveUser()  {
        
    }
}
