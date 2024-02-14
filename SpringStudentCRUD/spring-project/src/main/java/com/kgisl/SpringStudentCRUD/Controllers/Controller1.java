package com.kgisl.SpringStudentCRUD.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.kgisl.SpringStudentCRUD.model.Helloworld;
 
@Controller
@RequestMapping("/controller1")
@Scope("singleton")
public class Controller1 {
 
    @Autowired
    private Helloworld helloworld;
 
    @GetMapping("/info1")
    @ResponseBody
    public String getInfo() {
        return "Controller 1 - MyBean HashCode: " + helloworld.hashCode();
    }
    {
        System.out.println();
    }
}