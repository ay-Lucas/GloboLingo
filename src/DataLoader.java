import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataLoader {

    private UserList userList;
    private ProgressList progressList;

    // Constant for the user and progress file paths
    private static final String USER_FILE = "./json/User.json"; 
    private static final String PROGRESS_FILE = "./json/Progress.json"; 

    // Constructor
    public DataLoader() {
        userList = UserList.getInstance();
        progressList = ProgressList.getInstance();
    }

    // Method to get the list of users from the JSON file
    public UserList getUserList() {
        List<User> users;
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(USER_FILE)) {
            // Deserialize the JSON file into a List<User>
            users = gson.fromJson(reader, new TypeToken<List<User>>() {}.getType());
            userList.setUsers(users);  // Assuming UserList has a method to set users
        } catch (IOException e) {
            e.printStackTrace();  // Print any IO exceptions
        }

        return userList;  // Return the list of users
    }

    // Method to get the progress list
    public ProgressList getProgressList() {
        // For simplicity, we’ll skip loading progress from a file for now
        return this.progressList;
    }

    // Main method to run DataLoader
    public static void main(String[] args) {
        DataLoader dataLoader = new DataLoader();

        // Load user list and display
        UserList userList = dataLoader.getUserList();
        System.out.println("Loaded Users:");
        for (User user : userList.getUsers()) {
            System.out.println("Username: " + user.getName());
            System.out.println("First Name: " + user.getFirstName());
            System.out.println("Last Name: " + user.getLastName());
            System.out.println("Level: " + user.getLevel());
            System.out.println("UUID: " + user.getUUID());
            System.out.println("---------");
        }

        // Placeholder for progress list loading
        ProgressList progressList = dataLoader.getProgressList();
        System.out.println("Progress List loaded (not yet implemented fully).");
    }
}
