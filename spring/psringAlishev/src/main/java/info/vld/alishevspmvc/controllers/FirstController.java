package info.vld.alishevspmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request,
                            Model model) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

//        System.out.println("Hello, " + name + " " + surname);

        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname) {

//        System.out.println("Hello, " + name + " " + surname);


        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) int a,
                             @RequestParam(value = "b", required = false) int b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model) {
        double result;

        switch (action) {
            case "multiplication":
                result = a * (double) b;
                break;
            case "division":
                result = a / (double) b;
                break;
            case "subtraction":
                result = a - (double) b;
                break;
            case "addition":
                result = a + (double) b;
                break;
            default:
                result = 0;
                break;
        }

        model.addAttribute("result", result);

        return "first/calculator";
    }
}
