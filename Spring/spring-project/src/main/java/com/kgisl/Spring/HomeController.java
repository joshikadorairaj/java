package com.kgisl.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {

    {
        System.out.println("HomeController loaded.");
    }
    @Autowired
    private Employee employee;
    //constructor injection=>value is assigned to local variable inside constructor
    // HomeController(Employee employee) {
    //     this.employee = employee;
    // }

    @RequestMapping("/")
    public String showPage() {
        employee.show();
        return "home";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String user(@Validated User user, Model model) {
        System.out.println("User Page Requested");
        model.addAttribute("userName", user.getUserName());
        return "user";
    }

    @RequestMapping("/helloworld")
    public String hello(ModelMap map) {
        String helloWorldMessage = "Hello world!";
        String welcomeMessage = "Welcome!";
        map.addAttribute("helloMessage", helloWorldMessage);
        map.addAttribute("welcomeMessage", welcomeMessage);
        return "home";
    }
}
// public class HomeController {

// /**
// * Simply selects the home view to render by returning its name.
// */
// @RequestMapping(value = "/", method = RequestMethod.GET)
// public String home(Locale locale, Model model) {
// System.out.println("Home Page Requested, locale = " + locale);
// Date date = new Date();
// DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
// DateFormat.LONG, locale);

// String formattedDate = dateFormat.format(date);

// model.addAttribute("serverTime", formattedDate);

// return "home";
// }

// @RequestMapping(value = "/user", method = RequestMethod.POST)
// public String user(@Validated User user, Model model) {
// System.out.println("User Page Requested");
// model.addAttribute("userName", user.getUserName());
// return "user";
// }
// }