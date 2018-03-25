package com.example.triangle.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("title", "Welcome To Triangle Application!");
        model.addAttribute("infoMessage", "This is a simple application for evaluating the type of a triangle.");
        model.addAttribute("promptMessage", "Please provide input for all the triangle sides.");
        model.addAttribute("btnMessage", "Evaluate");
        return "home";
    }

}
