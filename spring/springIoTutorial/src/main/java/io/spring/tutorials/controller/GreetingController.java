package io.spring.tutorials.controller;

import io.spring.tutorials.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {
    public static final String GREETING = "greeting";

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("testing", new Greeting());
        return GREETING;
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute(GREETING, greeting);
        return "result";
    }

}
