import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class UserTreeMap {
    public static void main(String[] args) {
        adduser();
        updateuser();
        removeuser();
        displayuser();
    }
    static Map<Integer,User> users=new TreeMap<>();
    
    static void adduser(){
        User obj1=new User(1, "john_doe", "password123", "john@example.com", "John", "Doe", "athlete");

         User obj2=new User(2, "jane_smith", "pass456", "jane@example.com", "Jane", "Smith", "coach");

        User obj3=new User(3, "Gobinath", "pass@123", "gobinath@gmail.com", "Gobinath", "T", "athlete");

        User obj4=new User(4, "Swathi", "pass@123", "swathi@gmail.com", "swathi", "N", "athlete");

         User obj5=new User(5, "Joshika", "pass@123", "joshika@gmail.com", "Joshika", "D", "athlete");


        users.put(obj1.getUser_id(),obj1);
        users.put(obj2.getUser_id(),obj2);
        users.put(obj3.getUser_id(),obj3);
        users.put(obj4.getUser_id(),obj4);
        users.put(obj5.getUser_id(),obj5);
    }
    
    static void displayuser() {
        for (User user : users.values()) {
            System.out.println(user);
            
        }
            
        }
    static void updateuser() {
        User userToUpdate = users.get(1); 
        userToUpdate.setUsername("updated_username");
        userToUpdate.setEmail("updated@example.com");

    }
    static void removeuser() {
        users.remove(2);
    }
}
