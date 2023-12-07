import java.util.ArrayList;

public class UserArrayList {
    static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        adduser();
        //displayuser();
        //removeuser();
        //displayuser();
        updateuser();
        displayuser();
        //searchuser();
        //displayuser();
    }

    public static void adduser() {
        users.add(new User(1, "john_doe", "password123", "john@example.com", "John", "Doe", "athlete"));

        users.add(new User(2, "jane_smith", "pass456", "jane@example.com", "Jane", "Smith", "coach"));

        users.add(new User(3, "Gobinath", "pass@123", "gobinath@gmail.com", "Gobinath", "T", "athlete"));

        users.add(new User(4, "Swathi", "pass@123", "swathi@gmail.com", "swathi", "N", "athlete"));

        users.add(new User(5, "Joshika", "pass@123", "joshika@gmail.com", "Joshika", "D", "athlete"));
    }

    public static void displayuser() {
        for (User i : users) {
            System.out.println("User ID: " + i.getUser_id());
            System.out.println("Username: " + i.getUsername());
            System.out.println("Email: " + i.getEmail());
            System.out.println("First Name: " + i.getFirst_name());
            System.out.println("Last Name: " + i.getLast_name());
            System.out.println("User Type: " + i.getUser_type());
            System.out.println();
        }
    }

    public static void removeuser() {
        users.remove(4);

        users.removeIf(user -> user.getEmail() == "gobinath@gmail.com");
    }

    public static void updateuser() {
        // for (User i : users) {
        //     if (i.getUser_id() == 4) {
        //         i.setFirst_name("UpdatedName");
        //         i.setEmail("updated@example.com");
        //     }
        // }

        users.set(2,new User(2, "Rashmika", "pass456", "rashmika@example.com", "Rashmika", "D", "coach"));
    }

    public static void searchuser() {
        for (User i : users) {
            if (i.getUsername().equals("Joshika")) {
                System.out.println("User Found:");
                System.out.println("User ID: " + i.getUser_id());
                System.out.println("Username: " + i.getUsername());
                System.out.println("Email: " + i.getEmail());
                System.out.println("First Name: " + i.getFirst_name());
                System.out.println("Last Name: " + i.getLast_name());
                System.out.println("User Type: " + i.getUser_type());
                System.out.println();
            }

        }
    }
}
