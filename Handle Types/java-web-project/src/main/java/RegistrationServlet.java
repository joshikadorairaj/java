import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mysql.cj.jdbc.MysqlDataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
    private Connection jdbcConnection;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Registration> listreg = new ArrayList<>();
        String sql = "SELECT * FROM Registration";
        Statement statement;
        try {
            connect();
            statement = jdbcConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int registration_id = resultSet.getInt("registration_id");
                String event_name = resultSet.getString("event_name");
                String athlete_name = resultSet.getString("athlete_name");
                Date registration_date = resultSet.getDate("registration_date");
                Registration registration = new Registration(registration_id, event_name, athlete_name,
                        registration_date);
                listreg.add(registration);

            }
            
            // Athletes who registered for the most events in October.
            List<Registration> octoberRegistrations = listreg.stream()
                    .filter(registration -> registration.getRegistration_date().toLocalDate().getMonthValue() == 10)
                    .collect(Collectors.toList());
            // Group registrations by athlete name
            Map<String, Long> registrationsByAthlete = octoberRegistrations.stream()
                    .collect(Collectors.groupingBy(Registration::getAthlete_name, Collectors.counting()));
            // Find the athlete(s) with the most registrations
            Optional<Map.Entry<String, Long>> maxEntry = registrationsByAthlete.entrySet().stream()
                    .max(Comparator.comparing(Map.Entry::getValue));
            String athleteWithMostRegistrations = maxEntry.map(Map.Entry::getKey).orElse("No registrations in october");
            // GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
            String json1 = new Gson().toJson(athleteWithMostRegistrations);

            // Athletes who registered for events with names that are palindromes
            // eg."racecar").
            List<String> palindromeAthletes = listreg.stream()
                    .filter(registration -> isPalindrome(registration.getEvent_name()))
                    .map(Registration::getAthlete_name)
                    .distinct()
                    .collect(Collectors.toList());
            String json2 = new Gson().toJson(palindromeAthletes);

            // Events with names containing "Marathon" and registered in September.
            List<Registration> filteredRegistrations = listreg.stream()
                    .filter(registration -> registration.getEvent_name().contains("Marathon"))
                    .filter(registration -> registration.getRegistration_date().toLocalDate().getMonthValue() == 9)
                    .collect(Collectors.toList());
            String json3 = new Gson().toJson(filteredRegistrations);

            // Athletes who registered for events in September and October.
            List<Registration> septemberOctoberRegistrations = listreg.stream()
                    .filter(registration -> {
                        int month = registration.getRegistration_date().toLocalDate().getMonthValue();
                        return month == 9 || month == 10;
                    })
                    .collect(Collectors.toList());
            String json4 = new Gson().toJson(septemberOctoberRegistrations);

            // Events with the most registrations in October.
            Map<String, Long> registrationsInOctober = listreg.stream()
                    .filter(registration -> registration.getRegistration_date().toLocalDate().getMonthValue() == 10)
                    .collect(Collectors.groupingBy(Registration::getEvent_name, Collectors.counting()));
            // Find the event(s) with the most registrations
            Optional<Map.Entry<String, Long>> maxEntry1 = registrationsInOctober.entrySet().stream()
                    .max(Comparator.comparing(Map.Entry::getValue));
            String eventWithMostRegistrationsInOctober = maxEntry1.map(Map.Entry::getKey)
                    .orElse("No registrations in October");
            String json5 = new Gson().toJson(eventWithMostRegistrationsInOctober);

            // Events registered on the same date as "Weightlifting Competition."
            List<String> eventsOnSameDate = listreg.stream()
                    .filter(registration -> registration.getEvent_name().equals("Weightlifting Competition"))
                    .flatMap(weightliftingEvent -> listreg.stream()
                            .filter(registration -> !registration.getEvent_name().equals("Weightlifting Competition")
                                    && registration.getRegistration_date()
                                            .equals(weightliftingEvent.getRegistration_date()))
                            .map(Registration::getEvent_name))
                    .distinct()
                    .collect(Collectors.toList());
            String json6 = new Gson().toJson(eventsOnSameDate);

            JsonObject mainJsonObject = new JsonObject();

            JsonArray table = new Gson().toJsonTree(listreg).getAsJsonArray();
            mainJsonObject.add("table1", table);
            
            JsonArray registrationsArray = new JsonArray();
            registrationsInOctober.forEach((eventName, count) -> {
                JsonObject registrationObject = new JsonObject();
                registrationObject.addProperty("eventName", eventName);
                registrationObject.addProperty("count", count);
                registrationsArray.add(registrationObject);
            });

            // Add the JSON array to the mainJsonObject
            mainJsonObject.add("registrationsInOctober", registrationsArray);

            // Add the JSON array to the mainJsonObject
            mainJsonObject.add("registrationsInOctober", registrationsArray);
            JsonArray octoberRegistrationsarr = new Gson().toJsonTree(octoberRegistrations).getAsJsonArray();
            mainJsonObject.add("octoberRegistrations", octoberRegistrationsarr);
            JsonArray palindromeAthletesarr = new Gson().toJsonTree(palindromeAthletes).getAsJsonArray();
            mainJsonObject.add("palindromeAthletes", palindromeAthletesarr);
            JsonArray filteredRegistrationsarr = new Gson().toJsonTree(filteredRegistrations).getAsJsonArray();
            mainJsonObject.add("filteredRegistrations", filteredRegistrationsarr);
            JsonArray septemberOctoberRegistrationsarr = new Gson().toJsonTree(septemberOctoberRegistrations)
                    .getAsJsonArray();
            mainJsonObject.add("septemberOctoberRegistrations", septemberOctoberRegistrationsarr);
            // JsonArray registrationsInOctoberarr = new
            // Gson().toJsonTree(registrationsInOctober).getAsJsonArray();
            // mainJsonObject.add("registrationsInOctober", registrationsInOctoberarr);
            JsonArray eventsOnSameDatearr = new Gson().toJsonTree(eventsOnSameDate).getAsJsonArray();
            mainJsonObject.add("eventsOnSameDate", eventsOnSameDatearr);
            String combinedJson = new Gson().toJson(mainJsonObject);

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(combinedJson);

            resultSet.close();
            statement.close();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private boolean isPalindrome(String s) {
        String clean = s.toLowerCase().replaceAll("[^a-z]", "");
        return clean.equals(new StringBuilder(clean).reverse().toString());
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            MysqlDataSource d = new MysqlDataSource();
            d.setUrl("jdbc:mysql://localhost:3306/joshika_d");
            d.setUser("root");
            d.setPassword("");
            jdbcConnection = d.getConnection();
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
}