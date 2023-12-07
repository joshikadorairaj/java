import java.util.HashMap;
import java.util.Map;

public class Registration
{
    private int registration_id;
    private int event_id;
    private int athlete_id;
    private String registration_date;

    public Registration(int registration_id, int event_id, int athlete_id, String registration_date) {
        this.registration_id = registration_id;
        this.event_id = event_id;
        this.athlete_id = athlete_id;
        this.registration_date = registration_date;
    }

    public int getRegistration_id() {
        return registration_id;
    }

    public void setRegistration_id(int registration_id) {
        this.registration_id = registration_id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getAthlete_id() {
        return athlete_id;
    }

    public void setAthlete_id(int athlete_id) {
        this.athlete_id = athlete_id;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public static void main(String[] args)
    {
        // Creating sample data
        Registration[] registrations = new Registration[5];
        registrations[0] = new Registration(1, 101, 1001, "2023-10-10");
        registrations[1] = new Registration(2, 102, 1002, "2023-10-11");
        registrations[2] = new Registration(3, 103, 1003, "2023-10-10");
        registrations[3] = new Registration(4, 104, 1004, "2023-10-13");
        registrations[4] = new Registration(5, 105, 1005, "2023-10-10");

        // Create a map to store registration_date and count
        Map<String, Integer> dateCountMap = new HashMap<>();
        // Count registration_date occurrences
        for (Registration registration : registrations) {
            String registrationDate = registration.getRegistration_date();
            dateCountMap.put(registrationDate, dateCountMap.getOrDefault(registrationDate, 0) + 1);
        }
        // Print registration_date and count
        for (Map.Entry<String, Integer> entry : dateCountMap.entrySet()) {
            String registrationDate = entry.getKey();
            int count = entry.getValue();
            System.out.println("Registration Date: " + registrationDate + ", Count: " + count);
        }
    }
}
