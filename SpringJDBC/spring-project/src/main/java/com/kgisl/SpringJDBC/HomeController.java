package com.kgisl.SpringJDBC;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/home")
public class HomeController {

    // field level or variable level
    // private EmployeeDao employeeDao;
    @Autowired

    private RegistrationDao registrationDao;

    @RequestMapping("/")
    public String showPage() {
        // int status = employeeDao.saveEmployee(new Employee(102, "Amit", 35000));
        // System.out.println(status);

        // int status1 = employeeDao.updateEmployee(new Employee(102, "Sonoo", 15000));
        // System.out.println(status1);

        // int status2 = employeeDao.saveEmployee(new Employee(101, "Josh", 21000));
        // System.out.println(status2);
        // return null;

        // Employee e = new Employee();
        // e.setId(102);
        // int status = employeeDao.deleteEmployee(e);
        // System.out.println(status);
        // return null;

        // List<Employee> allEmployees = employeeDao.allEmployees();
        // allEmployees.stream().forEach(System.out::println);

        List<Registration> allregistration = registrationDao.allRegistration();

        // Athletes who registered for the most events in October.
        List<Registration> octoberRegistrations = allregistration.stream()
                .filter(registration -> registration.getRegistration_date().toLocalDate().getMonthValue() == 10)
                .collect(Collectors.toList());
        // Group registrations by athlete name
        Map<String, Long> registrationsByAthlete = octoberRegistrations.stream()
                .collect(Collectors.groupingBy(Registration::getAthlete_name, Collectors.counting()));
        // Find the athlete(s) with the most registrations
        Optional<Map.Entry<String, Long>> maxEntry = registrationsByAthlete.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue));
        String athleteWithMostRegistrations = maxEntry.map(Map.Entry::getKey).orElse("No registrations in october");
        octoberRegistrations.stream().forEach(System.out::println);
        String json1 = new Gson().toJson(athleteWithMostRegistrations);

        // Athletes who registered for events with names that are palindromes
        // eg."racecar").
        List<String> palindromeAthletes = allregistration.stream()
                .filter(registration -> isPalindrome(registration.getEvent_name()))
                .map(Registration::getAthlete_name)
                .distinct()
                .collect(Collectors.toList());
        palindromeAthletes.stream().forEach(System.out::println);
        String json2 = new Gson().toJson(palindromeAthletes);

        // Events with names containing "Marathon" and registered in September.
        List<Registration> filteredRegistrations = allregistration.stream()
                .filter(registration -> registration.getEvent_name().contains("Marathon"))
                .filter(registration -> registration.getRegistration_date().toLocalDate().getMonthValue() == 9)
                .collect(Collectors.toList());
        filteredRegistrations.stream().forEach(System.out::println);
        String json3 = new Gson().toJson(filteredRegistrations);

        // Athletes who registered for events in September and October.
        List<Registration> septemberOctoberRegistrations = allregistration.stream()
                .filter(registration -> {
                    int month = registration.getRegistration_date().toLocalDate().getMonthValue();
                    return month == 9 || month == 10;
                })
                .collect(Collectors.toList());
        septemberOctoberRegistrations.stream().forEach(System.out::println);
        String json4 = new Gson().toJson(septemberOctoberRegistrations);

        // Events with the most registrations in October.
        List<String> eventsWithMostRegistrationsInOctober = allregistration.stream()
                .filter(registration -> {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(registration.getRegistration_date());
                    return cal.get(Calendar.MONTH) + 1 == 10; // Calendar.MONTH is zero-based
                })
                .collect(Collectors.groupingBy(Registration::getEvent_name, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(entry -> entry.getValue()))
                .map(entry -> List.of(entry.getKey()))
                .orElse(List.of("No registrations in October"));
        eventsWithMostRegistrationsInOctober.stream().forEach(System.out::println);
        String json5 = new Gson().toJson(eventsWithMostRegistrationsInOctober);

        // Events registered on the same date as "Weightlifting Competition."
        List<String> eventsOnSameDate = allregistration.stream()
                .filter(registration -> registration.getEvent_name().equals("Weightlifting Competition"))
                .flatMap(weightliftingEvent -> allregistration.stream()
                        .filter(registration -> !registration.getEvent_name().equals("Weightlifting Competition")
                                && registration.getRegistration_date()
                                        .equals(weightliftingEvent.getRegistration_date()))
                        .map(Registration::getEvent_name))
                .distinct()
                .collect(Collectors.toList());
        eventsOnSameDate.stream().forEach(System.out::println);
        String json6 = new Gson().toJson(eventsWithMostRegistrationsInOctober);

        JsonObject mainJsonObject = new JsonObject();

        JsonArray table = new Gson().toJsonTree(allregistration).getAsJsonArray();
        mainJsonObject.add("table1", table);

        JsonArray octoberRegistrationsarr = new Gson().toJsonTree(octoberRegistrations).getAsJsonArray();
        mainJsonObject.add("octoberRegistrations", octoberRegistrationsarr);
        JsonArray palindromeAthletesarr = new Gson().toJsonTree(palindromeAthletes).getAsJsonArray();
        mainJsonObject.add("palindromeAthletes", palindromeAthletesarr);
        JsonArray filteredRegistrationsarr = new Gson().toJsonTree(filteredRegistrations).getAsJsonArray();
        mainJsonObject.add("filteredRegistrations", filteredRegistrationsarr);
        JsonArray septemberOctoberRegistrationsarr = new Gson().toJsonTree(septemberOctoberRegistrations)
                .getAsJsonArray();
        mainJsonObject.add("septemberOctoberRegistrations", septemberOctoberRegistrationsarr);
        JsonArray eventsWithMostRegistrationsInOctoberarr = new Gson().toJsonTree(eventsWithMostRegistrationsInOctober)
                .getAsJsonArray();
        mainJsonObject.add("eventsWithMostRegistrationsInOctober", eventsWithMostRegistrationsInOctoberarr);
        JsonArray eventsOnSameDatearr = new Gson().toJsonTree(eventsOnSameDate).getAsJsonArray();
        mainJsonObject.add("eventsOnSameDate", eventsOnSameDatearr);

        String combinedJson = new Gson().toJson(mainJsonObject);
              Arrays.stream(combinedJson.split(","))
            .map(String::trim)
            .forEach(System.out::println);
        return null;
    }

    private boolean isPalindrome(String s) {
        String clean = s.toLowerCase().replaceAll("[^a-z]", "");
        return clean.equals(new StringBuilder(clean).reverse().toString());
    }

}